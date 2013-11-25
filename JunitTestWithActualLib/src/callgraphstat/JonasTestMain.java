package callgraphstat;

public class JonasTestMain implements JonasInterface {
    Sec se = s;
    static JonasInterface jid = new JonasAClass();
    JonasInterface jif = new JonasBClass();
    static JonasInterface jig;

    public static void main(String[] args) {
	jig = new JonasCClass();
	JonasInterface jia = new JonasAClass();
	JonasInterface jib = new JonasBClass();
	JonasCClass jic = new JonasCClass();
	checkMethod(jia);
	checkMethod(jib);
	checkMethod(jic);
	checkMethod(jid);
	checkMethod(jie);
	jic.methodC();
	s.dck();
    }

    public static void checkMethod(JonasInterface ji) {
	ji.interfaceMethod();
    }

    @Override
    public void interfaceMethod() {
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
