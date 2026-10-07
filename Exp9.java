import java.util.*;
import java.util.logging.*;

class Exp9{

    static Logger logger = Logger.getLogger("Test");

    public static void test(String name, Object act, Object exp){
        if(act.equals(exp)){
            logger.info(name+" PASS");
        }
        else{
            logger.severe(name+" FAIL");
        }
    }

    public static void main(String[] args) throws Exception{
        logger.setUseParentHandlers(false);

        FileHandler fh = new FileHandler("silent_log.txt");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);

        test("Addition",2+2,4);
        test("Sub",2-2,4);
        test("multiplication",2*2,4);
        test("String","abc".toUpperCase(),"ABC");
    }
}