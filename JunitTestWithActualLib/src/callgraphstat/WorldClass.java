/**
 *
 * @ProjectName JunitTestWithActualLib
 *
 * @PackageName callgraphstat
 *
 * @FileName WorldClass.java
 * 
 * @FileCreated Nov 2, 2013
 *
 * @Author MD. SHOHEL SHAMIM
 *
 * @CivicRegistration 19841201-0533
 *
 * MSc. in Software Technology
 *
 * Linnaeus University, Växjö, Sweden
 *
 */
package callgraphstat;

class WorldClass {
    Sec sec = new Sec();

    public static void methodOne() {
	Sec s = new Sec();
	s.nurse("SD", new WorldClass());
	new Sec().dck();
	Another.What();
	BBC bbc = new Another();
	bbc.Nothing();
	new Another().Ne(new Sec());
	Sec ss = new Sec(new Sec());
    }

    public void testing() {

    }

    public void methodTwo() {
	this.sec.dck();
    }
}

class Another implements BBC {
    public static void What() {

    }

    public void Ne(Sec s) {

    }

    @Override
    public void Nothing() {
    }
}

interface BBC {
    public void Nothing();
}