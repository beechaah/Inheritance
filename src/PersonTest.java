import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest
{
    Person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Person("000001", "Ally", "Test1", 2000);
        p2 = new Person("000002", "Amiah", "Test2", 2005);
        Person.setIDSeed(0);
        p3 = new Person("Rob", "Test3", 2004);
        p4 = new Person( "Dylan", "Test4", 2007);
        p5 = new Person( "Mack", "Test5", 2002);
        p6 = new Person( "Zoe", "Test6", 2006);
    }

    @Test
    void getIDSeed()
    {
        assertEquals(4, Person.getIDSeed());
    }

    @Test
    void getIDNum()
    {
        assertEquals("000001", p1.getIDNum());
    }

    @Test
    void getFirstName()
    {
        assertEquals("Ally", p1.getFirstName());
    }

    @Test
    void getLastName()
    {
        assertEquals("Test1", p1.getLastName());
    }

    @Test
    void getYOB()
    {
        assertEquals(2000, p1.getYOB());
    }

    @Test
    void setIDNum()
    {
        p1.setIDNum("000002");
        assertEquals("000002", p1.getIDNum());
    }

    @Test
    void setFirstName()
    {
        p1.setFirstName("Amiah");
        assertEquals("Amiah", p1.getFirstName());
    }

    @Test
    void setLastName()
    {
        p1.setLastName("Test2");
        assertEquals("Test2", p1.getLastName());
    }

    @Test
    void setYOB()
    {
        p1.setYOB(2005);
        assertEquals(2005, p1.getYOB());
    }

    @Test
    void equals()
    {
        p1.setIDNum("000002");
        p1.setFirstName("Amiah");
        p1.setLastName("Test2");
        p1.setYOB(2005);
        assertEquals(true, p1.equals(p2));
    }
}