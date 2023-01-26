import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rule {
    String origin;
    String read;
    
    String dest;
    String write;
    String LR;
    
    public Rule( String ruleStr ) {
        compile(ruleStr);
    }
    
    private void compile( String ruleStr ) {
        String patternAsString = "\\((.+), (.+)\\) -> \\((.+), (.+), ([RL])\\)";
        Pattern pattern = Pattern.compile(patternAsString);
        Matcher matcher = pattern.matcher(ruleStr);
        if (matcher.find()) {
            origin = matcher.group(1);
            read = matcher.group(2);
    
            dest = matcher.group(3);
            write = matcher.group(4);
            LR = matcher.group(5);
        } else {
            System.out.println("!!! ---> invalid rule str");
        }
    }
    
    @Override
    public String toString() {
        return String.format("(%s, %s) -> (%s, %s, %s)", origin, read, dest, write, LR);
    }
}
