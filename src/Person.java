
public class Person implements Comparable<Person> {

    private int age;
    private int height;
    private String name;

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public int compareTo(Person p) {
        if (this.age == p.age) {
            return this.name.compareTo(p.name);
        } else {
            return this.age < p.age ? -1 : 1;
        }
    }

    public String toString() {
        return "[" + name + "," + age + "," + height + "]";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person p = (Person) o;
        return this.name.equals(p.name) && this.age == p.age && this.height == p.height;
    }
}
