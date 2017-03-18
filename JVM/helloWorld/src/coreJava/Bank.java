package coreJava;

public class Bank {
    String bankName = "";
    String branch = "";
    int zip = 0;
    float rateOfInterest = 0.0f;
    public static void main(String[] args) {
        SBI sbi = new SBI();
        sbi.getDetails();
        sbi.display();
        BOI boi = new BOI();
        boi.getDetails();
        boi.display();
        ICICI icici = new ICICI();
        icici.getDetails();
        icici.display();
    }
}

class SBI extends Bank{
    void getDetails(){
        this.bankName="SBI";
        this.branch="Mundka Delhi";
        this.zip=110059;
        this.rateOfInterest=3.5f;
    }
    void display(){
        System.out.println(this.bankName);
        System.out.println(this.branch);
        System.out.println(this.zip);
        System.out.println(this.rateOfInterest);
    }
}

class BOI extends  Bank{
    void getDetails(){
        this.bankName="BOI";
        this.branch="Gurgaon";
        this.zip=110059;
        this.rateOfInterest=5.2f;
    }
    void display(){
        System.out.println(this.bankName);
        System.out.println(this.branch);
        System.out.println(this.zip);
        System.out.println(this.rateOfInterest);
    }
}

class ICICI extends Bank{
    void getDetails(){
        this.bankName="ICICI";
        this.branch="Noida UP";
        this.zip=110059;
        this.rateOfInterest=5.5f;
    }
    void display(){
        System.out.println(this.bankName);
        System.out.println(this.branch);
        System.out.println(this.zip);
        System.out.println(this.rateOfInterest);
    }
}