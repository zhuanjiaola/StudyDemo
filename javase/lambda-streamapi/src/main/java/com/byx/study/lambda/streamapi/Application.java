package com.byx.study.lambda.streamapi;

/**
 * @author wang zhen xing
 * @date 2021/2/24 16:55
 */
public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        Greeting myGreeting = () -> System.out.println("111");
        application.greet(myGreeting);
        System.out.println();
        Greeting then = myGreeting.then(() -> System.out.println("222"));
        application.greet(then);
        System.out.println();
        Greeting then2 = then.then(() -> System.out.println("333"));
        application.greet(then2);
    }

    public void greet(Greeting greeting) {
        greeting.perform();
    }


    interface Greeting {
        void perform();

        default Greeting then(Greeting greeting) {
//            perform();
//            return greeting;
            return () -> {
                perform();
                greeting.perform();
            };
        }
    }


}

