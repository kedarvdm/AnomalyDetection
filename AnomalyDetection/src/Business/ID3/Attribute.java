package Business.ID3;


public class Attribute extends AbstractAttribute {

    //Outlook
    public static final int Sunny = 0;
    public static final int Overcast = 1;
    public static final int Rainy = 2;

    //Turbulence
    public static final int Normal = 0;
    public static final int Turbulent = 1;
    
    //Storm
    public static final int No = 0;
    public static final int Yes = 1;
    
    //Collision possibility
    public static final int Low = 0;
    public static final int Med = 1;
    public static final int High = 2;

    //Deviation
    public static final int DeviationNo = 0;
    public static final int DeviationYes = 1;

    enum Outlook {

        Sunny, Overcast, Rainy;
    }

    enum Turbulence {

        Normal, Turbulent;
    }

    enum Collision {

        Low, Med, High;
    }

    enum Storm {

        Yes,No;
    }

    enum Deviation {

        DeviationNo, DeviationYes;
    }

    public Attribute(String name, int value) {
        super(name, value);
    }

    public Attribute(String name, String value) {
        super(name, value);
    }
}