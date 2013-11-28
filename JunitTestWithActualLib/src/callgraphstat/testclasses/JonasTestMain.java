package callgraphstat.testclasses;

public class JonasTestMain implements JonasInterface {
    Sec se = s;
    static Sec sess = s;
    Sec ses = se;
    static JonasInterface jikj = new JonasAClass();
    static JonasInterface jid = new JonasAClass("S");
    static JonasInterface jih = new JonasAClass(new Sec());
    static JonasInterface jihh = new JonasAClass(sess);
    JonasInterface jif = new JonasBClass();
    JonasInterface jii = new JonasCClass();
    static JonasInterface jig;

    public static void main(String[] args) {
	JonasInterface[] array = new JonasInterface[3];
	array[0] = new JonasAClass();
	array[1] = new JonasBClass();
	array[2] = new JonasCClass();

	array[0].interfaceMethod();
	JonasInterface arayB = array[1];
	arayB.interfaceMethod();
	JonasCClass arayC = (JonasCClass) array[2];
	arayC.interfaceMethod();

	// jig = new JonasCClass();
	JonasInterface jia = new JonasAClass();
	JonasInterface jib = new JonasBClass();
	JonasInterface jib1 = new JonasBClass();
	JonasInterface jib2 = new JonasBClass();
	JonasCClass jic = new JonasCClass();
	jig = new JonasCClass();
	s.dck();
	jia.interfaceMethod();
	jib.interfaceMethod();
	jib1.interfaceMethod();
	jib2.interfaceMethod();
	jic.interfaceMethod();
	jid.interfaceMethod();
	checkMethod(jia);
	checkMethod(jib);
	checkMethod(jic);
	checkMethod(jid);
	checkMethod(jie);
	jic.methodC();
	s.dck();
	checkMethod(jia, jib, jid, jie);
	jib.intrfaceCheckMethod(jia, jib, jid, jie);
    }

    public static void checkMethod(JonasInterface ji) {
	ji.interfaceMethod();
    }

    public static void checkMethod(JonasInterface ji, JonasInterface jj,
	    JonasInterface jc, JonasInterface jf) {
	ji.interfaceMethod();
	jj.interfaceMethod();
    }

    @Override
    public void interfaceMethod() {
    }

    @Override
    public void intrfaceCheckMethod(JonasInterface ji, JonasInterface jj,
	    JonasInterface jc, JonasInterface jf) {
    }
}

class AAA extends ABCD {
    void oo() {

    }
}

abstract class ABCD {
    void m() {

    }
}
