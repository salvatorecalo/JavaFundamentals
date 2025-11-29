public class TestBase {
    
    /* Se volessimo inizializzare la classe Square prima di avviare i testi una singola volta
     prima di tutti i test*/
    @BeforeAll
    public void setup() {
        Square s = new Square(21);
    }

    /* Se invece volessimo inizializzare la classe square ogni volta che avviamo un nuovo test */
    @BeforeEach
    public void setup() {
        Square s = new Square(21);
    }


    @Test
    public void testArea() {
        assertTrue(21, s.getArea(), "L'area non è di 21*21");
    } 
    
}
