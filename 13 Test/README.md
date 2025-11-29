# Cosa sono i test

I test sono un modo per automatizzare dei processi che normalmente sull'app dovremmo eseguire noi stessi, ad es nel lab 3 inserire materiali, ricette, ristoranti, testare le singole funzioni una per una. Questo può risultare essere molto noioso e prolisso nel tempo.

# Come scrivere un test 

Per dire a JUnit (la libreria che ci consente di creare i test) bisogna inserire prima della riga in cui dichiariamo il test l'annotazione @Test

## Esempio 
```

public class Square {
   privte double lato;

   public class Square(double l) {
    this.lato = l;
   }

   double getLato() {
    return this.lato;
   }

   double getArea() {
    return this.lato*this.lato;
   }

   ...
}
public class TestStack {
    
    @Test
    public void Test1() {
        Square s = new Square(21);

        assertTrue(s.getLato(), 21, "il lato non è 21");
    }

    @Test
    public void Test1() {
        Square s = new Square(21);

        assertFalse(s.getArea(), 400, "l'area non è 400");
    }
}
```

Come possiamo vedere in questo esempio noi stiamo andando a creare un'istanza della classe quadrato e successivamente stiamo andando a verificare se il lato con cui abbiamo creato questa
istanza è veramente 21 come avevamo impostato nel codice dell classe quadrato

## È possibile non creare l'istanza della classe Square in ogni test
La risposta è si, possiamo usare @BeforeEach per creare l'istanza della classe prima che ogni test venga eseguito.

@BeforeEach ci consente di specificare un set di istruzioni da eseguire prima di ogni test 
(Lo stesso farà @AfterEach ma dopo ogni test)

## Esempio

```

public class Square {
   privte double lato;

   public class Square(double l) {
    this.lato = l;
   }

   double getLato() {
    return this.lato;
   }

   double getArea() {
    return this.lato*this.lato;
   }

   ...
}
public class TestStack {
    
    @BeforeEach
    public void setup() {
        Square s = new Square(21);
    }
    @Test
    public void Test1() {
        assertTrue(s.getLato(), 21, "il lato non è 21");
    }

    @Test
    public void Test1() {
        assertFalse(s.getArea(), 400, "l'area non è 400");
    }
}
```

Nota bene questo eseguirà queste istruzioni ogni volta che si avvia un nuovo test.

# È possibile eseguirlo prima di tutti una sola volta?

Si usando @BeforeAll al posto di @BeforeEach che avviera1 il setup una sola volta prima di eseguire tutti i test

# Quali sono le istruzioni per testare le mie variabili?

```
assertTrue(boolean Test) // Controlla se la condizione che passiamo è True o False e non torna errore è True
assertFalse(boolean Test) // Controlla se la condizione che passiamo è True o False e non torna errore se è False

assertEqual(expected, actual) // Controlla se i due oggetti di tipo primitivo da noi passati sono uguali (ad es int, double, ecc.)

assertSame(Object expected, Object actual) // Controlla se i due oggetti da noi passati si riferiscono alla stessa area di memoria 

assertNotSame(Object expected, Onject actual) // Il contrario di assertSame

assertNull(Object object) // Controlla se l'oggetto passato è null
assertNotNull(Object object) // Controlla se l'oggetto passato non è null

fail() // Per far fallire un test sono determinate condizioni scelte da noi
```

# Qual è la differenza tra Failure e Error?

Una Failure si verifica quando un assert*() fallisce perchè la condizione che doveva controllare non è verificata e il programma genera un output ma non è quello desiderato

Un Error si verifica quando durante l'esecuzione del codice si verifica un errore 
(NullPointerException). Il programma non può avere un output a causa di un errore!

# Come posso testare un'eccezione?

Per testare un'eccezione bisogna passare l'eccezione deiserata al parametro expected all'interno di @Test()

As esempio @Test(expected=StackException.class)

# Test Suite

Ci consente di avviare un insieme di test come un singolo lotto

```
@RunWith(Suite.class)
@SuiteClasses({
TestStack.class, AnotherTest.class
})
```
Nel codice qua sopra stiamo dichiarando la Suite con la sintassi @RunWith(Suite.class) e poi all'interno del costruttore di SuiteClasses stiamo passando i test da eseguire

# Come posso skippare un test
Basta inserire prima della riga con @Test la seguente istruzione: @Ignore("")
dove la stringa tra parentesti rappresenta la motivazione per la quale stiamo skippando il seguente test ad esempio

@Ignore("Test must be finished before we can use it")

O aggiungendo l'istruzione @Disabled prima del test

Dove sta la differenza?

Semplicemente con @Disabled il test non viene eseguito ma viene lo stesso contato nel test count che esegue JUnit 