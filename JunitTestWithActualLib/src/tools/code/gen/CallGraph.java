package tools.code.gen;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import recoder.java.reference.TypeReference;

class Pack {
    String source;
    String first;
    String last;

    Pack(String s, String f, String l) {
	this.source = s.trim();
	this.first = f.trim();
	this.last = l.trim();
    }
}

class AClass {
    Descriptions describedClass = null;
    boolean isMain = false;
    String packageName = "";
    String className = "";
    String packCombClass = "";
    List<Pack> imports = new ArrayList<Pack>();
    List<AField> fields = new ArrayList<AField>();

    // package and class
    AClass(String p, String c) {
	packageName = p.trim();
	className = c.trim();
	packCombClass = packageName.concat(".").concat(className);
    }

    void addField(AField field) {
	boolean found = false;
	for (AField f : fields) {
	    if (f.name.equalsIgnoreCase(field.name)) {
		found = true;
		break;
	    }
	}
	if (!found) {
	    fields.add(field);
	}
    }
}

class AField {
    Field field = null;
    // if needs to check package
    TypeReference typeReference = null;
    // class
    String type = "";
    String name = "";
    List<CObject> classToAccess = new ArrayList<CObject>();
    List<CObject> methodToAccess = new ArrayList<CObject>();

    AField(Field originalField, TypeReference typeReference, String type,
	    String name) {
	this.field = originalField;
	this.typeReference = typeReference;
	this.type = type;
	this.name = name;
	// this.classToAccess.add(type);
    }

    void addClassToAccess(CObject cObject) {
	boolean found = false;
	for (CObject o : this.classToAccess) {
	    if (o.equals(cObject)) {
		found = true;
		break;
	    }
	}
	if (!found) {
	    classToAccess.add(cObject);
	}
    }
}

class CObject {
    String type = "";
    Descriptions description = null;

    public CObject(String type, Descriptions description) {
	this.type = type;
	this.description = description;
    }

    public boolean equals(Object object) {
	return this.hashCode() == object.hashCode();
    }

    public int hashCode() {
	return type.hashCode() + description.hashCode();
    }
}

public class CallGraph {
    private String path = "";
    List<AClass> listClass = new ArrayList<AClass>();

    public CallGraph(String path) {
	this.path = path;
    }

    // public DirectedGraphInterface getCallGraph() {
    // DirectedGraphInterface graph = new SetBasedDirectedGraph();
    //
    // CrossReferenceServiceConfiguration crsc = new
    // CrossReferenceServiceConfiguration();
    // crsc.getProjectSettings().setProperty(PropertyNames.INPUT_PATH, path);
    // crsc.getProjectSettings().ensureSystemClassesAreInPath();
    //
    // try {
    // SourceFileRepository sfr = crsc.getSourceFileRepository();
    // List<CompilationUnit> cul = sfr.getAllCompilationUnitsFromPath();
    // try {
    // crsc.getChangeHistory().updateModel();
    // } catch (Exception e) {
    // }
    // ForestWalker walker = new ForestWalker(cul);
    // boolean isMethod = false;
    //
    // String pack = "";
    // List<Pack> imports = new ArrayList<Pack>();
    // AClass aClass = null;
    // String cls = "";
    // AField aField = null;
    //
    // while (walker.next()) {
    // ProgramElement pe = walker.getProgramElement();
    // try {
    // System.out.println(pe);
    // } catch (Exception e) {
    // }
    // if (pe instanceof CompilationUnit) {
    // // reset
    // pack = "";
    // imports = new ArrayList<Pack>();
    // aClass = null;
    // aField = null;
    // cls = "";
    // } else if (pe instanceof PackageSpecification) {
    // try {
    // PackageSpecification p = (PackageSpecification) pe;
    // pack = (p.getPackageReference().toSource()).trim();
    // } catch (Exception e) {
    // }
    // } else if (pe instanceof Import) {
    // try {
    // Import pr = (Import) pe;
    // imports.add(new Pack(
    // (pr.getTypeReference().toSource()), pr
    // .getTypeReference().getFirstElement()
    // .toSource(), pr.getTypeReference()
    // .getName()));
    // } catch (Exception e) {
    // }
    // } else if (pe instanceof ClassDeclaration) {
    // System.out
    // .println("--------------CLASS DECLARATION------OK----------");
    // try {
    // ClassDeclaration cd = (ClassDeclaration) pe;
    // cls = (cd.getName()).trim();
    // aClass = new AClass(pack, cls);
    // for (Description d : MainClass.classDescriptions) {
    // if (d.getPackageName().equalsIgnoreCase(pack)
    // && d.getClassName().equals(cls)) {
    // aClass.describedClass = d;
    // break;
    // }
    // }
    // aClass.imports = imports;
    //
    // // System.out.println("\tPackage: " +
    // // aClass.packageName);
    // // System.out.println("\tClass: " + aClass.className);
    // // System.out.println("\t" + aClass.packCombClass);
    // // System.out
    // // .println("\t------------Package-------------");
    // // for (Pack p : aClass.imports) {
    // // System.out.println("\t\t" + p.source + "\t"
    // // + p.first + "\t" + p.last);
    // // }
    // listClass.add(aClass);
    //
    // System.out
    // .println("-----------------------------------------------");
    // } catch (Exception e) {
    // }
    // } else if (pe instanceof FieldDeclaration) {
    // FieldDeclaration fd = (FieldDeclaration) pe;
    // try {
    // System.err
    // .println("--------------------Field Source Code------------------");
    // System.err.println("Original Source: " + fd.toSource());
    // System.err
    // .println("--------------------Field Extract------------------");
    //
    // String classType = fd.getTypeReference().getName();
    // String fieldName = fd.getFieldSpecifications().get(0)
    // .getName();
    //
    // // Field of reflection
    // Field originalField = aClass.describedClass
    // .getFieldByName(fieldName);
    // if (originalField != null) {
    // aField = new AField(originalField,
    // fd.getTypeReference(), classType, fieldName);
    // aClass.addField(aField);
    // // sometimes same named field comes from diff.
    // // package,
    // // so, need to verify
    // String originalFieldsPackage = originalField
    // .getType().getPackage().getName();
    // System.err.println("Original Field package: "
    // + originalFieldsPackage);
    //
    // for (Description description : MainClass.classDescriptions) {
    // if (description
    // .getPackageName()
    // .equalsIgnoreCase(originalFieldsPackage)
    // && description.getClassName().equals(
    // classType)) {
    // aField.addClassToAccess(new CObject(
    // classType, description));
    // break;
    // }
    // }
    //
    // for (int i = 0; i < fd.getChildCount(); i++) {
    // System.out.println("\t\t\tChild:"
    // + fd.getChildAt(i));
    // if (fd.getChildAt(i) instanceof TypeReference) {
    // TypeReference t = (TypeReference) fd
    // .getChildAt(i);
    // System.out.println("TR: " + t.getName()
    // + "   " + t.toSource() + "   "
    // + t.getPackageReference());
    // } else if (fd.getChildAt(i) instanceof FieldSpecification) {
    // FieldSpecification fs = (FieldSpecification) fd
    // .getChildAt(i);
    // System.out.println("FS: " + fs.getName());
    // System.err.println(fs.getChildCount());
    //
    // for (int j = 0; j < fs.getChildCount(); j++) {
    // System.err.println("\t\t\t"
    // + fs.getChildAt(j));
    // if (fs.getChildAt(j) instanceof Operator) {
    // System.out.println("Operator: "
    // + fs.getChildAt(j)
    // .getLastElement());
    // }
    // }
    //
    // }
    // System.out.println("Child Source: "
    // + fd.getChildAt(i).toSource());
    // }
    //
    // System.out.println("Last Elem: "
    // + fd.getLastElement());
    //
    // System.err
    // .println("-------------------------------------------");
    // } else {
    // aField = null;
    // }
    // } catch (Exception e) {
    //
    // }
    // } else if (pe instanceof FieldReference) {
    // FieldReference fr = (FieldReference) pe;
    // try {
    //
    // } catch (Exception e) {
    // }
    // } else if (pe instanceof FieldSpecification) {
    // try {
    // FieldSpecification fs = (FieldSpecification) pe;
    // } catch (Exception e) {
    // }
    // } else if (pe instanceof MethodDeclaration) {
    // aField = null;
    // } else if (pe instanceof MethodReference) {
    // MethodReference mr = (MethodReference) pe;
    // try {
    // if (aField != null) {
    // System.err.println("\t\t\tMethod Ref: "
    // + mr.getName() + "     "
    // + mr.getChildCount());
    // for (int i = 0; i < mr.getChildCount(); i++) {
    // System.out.println("\t\t" + mr.getChildAt(i));
    // }
    // }
    // } catch (Exception e) {
    // }
    // } else if (pe instanceof TypeReference) {
    // TypeReference typeReference = (TypeReference) pe;
    // String name = typeReference.getName();
    // try {
    // if (aField != null) {
    // if (!aField.type.equals(name)) {
    // for (Description description : MainClass.classDescriptions) {
    // if (description.getClassName().equals(name)) {
    // aField.addClassToAccess(new CObject(
    // name, description));
    // break;
    // }
    // }
    // }
    // }
    // } catch (Exception e) {
    // }
    // }
    //
    // // else if (pe instanceof MethodDeclaration) {
    // // try {
    // // MethodDeclaration md = (MethodDeclaration) pe;
    // // Method declaredMethod = crsc.getSourceInfo().getMethod(
    // // md);
    // // try {
    // // System.err.println(declaredMethod.getFullName());
    // // } catch (UnresolvedReferenceException e) {
    // // }
    // // } catch (Exception e) {
    // // }
    // // }
    // }
    // } catch (ParserException pexcept) {
    // }
    //
    // return graph;
    // }
}