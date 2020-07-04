import org.omg.PortableServer.ServantLocatorPOA;

import javax.management.StandardEmitterMBean;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

class NameNUllException extends Exception {
    public NameNUllException(String message) {
        super(message);
    }
}

class Animal {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
    }

    private void eat() {
        System.out.println(name + "吃饭");
    }
}

class Dog extends Animal {
    public String kind;

    public Dog(String name, String kind) {
        super(name);
        this.kind = kind;
    }

    public void Deat() {
        System.out.println(super.getName());
    }
}

abstract class Cat {
    public String name;

    public Cat(String name) {
        this.name = name;
    }

    abstract public void eat();
}

interface Sleep {
    void sleep();
}

class HafCat extends Cat implements Sleep {
    public String kind;

    public HafCat(String name, String kind) {
        super(name);
        this.kind = kind;
    }
    public void eat() {
        System.out.println(this.name + this.kind);
    }

    @Override
    public void sleep() {

    }
}


public class TEst {
    public static void main(String[] args) throws NameNUllException {
      /*  int a;
        a = 10;
        boolean b;
        b = false;
        System.out.println(a);
        System.out.println(b);*/
      Dog dog = new Dog("AAA", "Black");
      dog.Deat();
      Cat cat = new Cat("haha") {
          @Override
          public void eat() {
              System.out.println("gaiguai");
          }
      };
      cat.eat();
      Cat cat1 = new HafCat("mm", "dd");
      cat1.eat();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
     /*   try {
            if (name.equals("aaa")) {
                throw new NameNUllException("名字为空");
            }
        }catch (NameNUllException e) {
            System.out.println(e.getMessage());
        }*/
        if (name.equals("aaa")) {
            throw new NameNUllException("名字为空");
        }

    }
}
