package models;

public enum PositionsEnum {
    CEO,
    Manager,
    Developer,
    Designer,
    QA_Engineer,
    HR,
    Intern,
    Other;

    public String toString() {
        return this.name();
    }
}
