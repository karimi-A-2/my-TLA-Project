import java.util.ArrayList;

public class Director {
    Console console;
    ArrayList<Rule> rules;
    ArrayList<String> accepts;
    ArrayList<String> rejects;
    String inStr;
    
    int index;
    String currentState;
    private StringBuilder strB;
    
    public Director() {
        console = new Console();
        rules = new ArrayList<>();
        accepts = new ArrayList<>();
        rejects = new ArrayList<>();
        
        index = 0;
        currentState = "q0";
    }
    
    public void start() {
        getRules();
        getAccepts();
        getRejects();
        getInstr();
    
    
        try {
            operate();
        } catch (AcceptException e) {
            System.out.println("accept");
        } catch (RejectException e) {
            System.out.println("reject");
        }
        console.printInfo(strB + " index: " + index);
        // printRules();
        // printAccepts();
        // printRejects();
    }
    
    private void operate() throws AcceptException, RejectException {
        console.printInfo(strB + " index: " + index);
        if (index == strB.length()) {
            strB.append("B");
        }
        if (index == -1) {
            strB.insert(0, "B");
            index++;
        }
        String read = strB.substring(index, index + 1);
        console.printInfo(String.format("(%s, %s)", currentState, read));
        for (Rule rule : rules) {
            if (rule.origin.equals(currentState) && rule.read.equals(read)) {
                console.printInfo("rule:" + rule);
                currentState = rule.dest;
                strB.replace(index, index + 1, rule.write);
                switch (rule.LR) {
                    case "L":
                        index--;
                        break;
                    case "R":
                        index++;
                        break;
                }
                if (accepts.contains(currentState)) {
                    throw new AcceptException();
                }
                if (rejects.contains(currentState)) {
                    throw new RejectException();
                }
                operate();
            }
        }
        throw new RejectException();
    }
    
    private void getInstr() {
        String str = console.getString();
        strB = new StringBuilder(str);
    }
    
    private void printRejects() {
        console.printInfo("rejects");
        System.out.println(rejects);
    }
    
    private void printAccepts() {
        console.printInfo("accepts");
        System.out.println(accepts);
    }
    
    private void getRejects() {
        // console.println("Enter rejects:");
        while (true) {
            String str = console.getString();
            if (str.equals("end")) {
                break;
            }
            rejects.add(str);
        }
    }
    
    private void getAccepts() {
        // console.println("Enter accepts:");
        while (true) {
            String str = console.getString();
            if (str.equals("end")) {
                break;
            }
            accepts.add(str);
        }
    }
    
    private void getRules() {
        // console.println("Enter rules line by line and Enter 'end' to stop reading");
        while (true) {
            String ruleStr = console.getString();
            if (ruleStr.equals("end")) {
                break;
            }
            Rule rule = new Rule(ruleStr);
            rules.add(rule);
        }
    }
    
    private void printRules() {
        console.printInfo("rules:");
        for (Rule rule : rules) {
            System.out.println(rule);
        }
    }
    
}