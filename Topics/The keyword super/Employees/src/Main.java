class Employee {

    protected String name;// write fields
    protected String email;
    protected int experience;

    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }// write constructor

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getExperience() {
        return experience;
    }
    // write getters
}

class Developer extends Employee {
    String mainLanguage;
    String[] skills;// write fields

    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {// write constructor
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }
    public String getMainLanguage(){
        return mainLanguage;
    }

    public String[] getSkills(){
        return skills;
    }// write getters
}

class DataAnalyst extends Employee {

    Boolean phd;
    String[] methods;// write fields

    public DataAnalyst (String name, String email, int experience, Boolean phd, String[] methods){
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods;
    }    // write constructor

    public Boolean isPhd() {
        return phd;
    }

    public String[] getMethods() {
        return methods;
    }
// write getters
}