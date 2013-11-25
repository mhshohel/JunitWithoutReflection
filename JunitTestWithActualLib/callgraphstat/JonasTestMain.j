;; Produced by JasminVisitor (BCEL)
;; http://bcel.sourceforge.net/
;; Sat Nov 23 15:39:56 CET 2013

.source JonasTestMain.java
.class public callgraphstat/JonasTestMain
.super java/lang/Object
.implements callgraphstat/JonasInterface

.field  se Lcallgraphstat/Sec;
.field static jid Lcallgraphstat/JonasInterface;

.method static <clinit>()V
.limit stack 2
.limit locals 0

.line 5
	new callgraphstat/JonasAClass
	dup
	invokespecial callgraphstat/JonasAClass/<init>()V
	putstatic callgraphstat.JonasTestMain.jid Lcallgraphstat/JonasInterface;
	return

.end method

.method public <init>()V
.limit stack 2
.limit locals 1
.var 0 is this Lcallgraphstat/JonasTestMain; from Label0 to Label1

Label0:
.line 3
	aload_0
	invokespecial java/lang/Object/<init>()V
.line 4
	aload_0
	getstatic callgraphstat.JonasTestMain.s Lcallgraphstat/Sec;
	putfield callgraphstat.JonasTestMain.se Lcallgraphstat/Sec;
Label1:
.line 3
	return

.end method

.method public static main([Ljava/lang/String;)V
.limit stack 2
.limit locals 4
.var 0 is args [Ljava/lang/String; from Label0 to Label1
.var 1 is jia Lcallgraphstat/JonasInterface; from Label2 to Label1
.var 2 is jib Lcallgraphstat/JonasInterface; from Label4 to Label1
.var 3 is jic Lcallgraphstat/JonasCClass; from Label6 to Label1

Label0:
.line 8
	new callgraphstat/JonasAClass
	dup
	invokespecial callgraphstat/JonasAClass/<init>()V
	astore_1
Label2:
.line 9
	new callgraphstat/JonasBClass
	dup
	invokespecial callgraphstat/JonasBClass/<init>()V
	astore_2
Label4:
.line 10
	new callgraphstat/JonasCClass
	dup
	invokespecial callgraphstat/JonasCClass/<init>()V
	astore_3
Label6:
.line 11
	aload_1
	invokestatic callgraphstat/JonasTestMain/checkMethod(Lcallgraphstat/JonasInterface;)V
.line 12
	aload_2
	invokestatic callgraphstat/JonasTestMain/checkMethod(Lcallgraphstat/JonasInterface;)V
.line 13
	aload_3
	invokestatic callgraphstat/JonasTestMain/checkMethod(Lcallgraphstat/JonasInterface;)V
.line 14
	getstatic callgraphstat.JonasTestMain.jid Lcallgraphstat/JonasInterface;
	invokestatic callgraphstat/JonasTestMain/checkMethod(Lcallgraphstat/JonasInterface;)V
.line 15
	aload_3
	invokevirtual callgraphstat/JonasCClass/methodC()V
.line 16
	getstatic callgraphstat.JonasTestMain.s Lcallgraphstat/Sec;
	invokevirtual callgraphstat/Sec/dck()V
Label1:
.line 17
	return

.end method

.method public static checkMethod(Lcallgraphstat/JonasInterface;)V
.limit stack 1
.limit locals 1
.var 0 is ji Lcallgraphstat/JonasInterface; from Label0 to Label1

Label0:
.line 20
	aload_0
	invokeinterface callgraphstat/JonasInterface/interfaceMethod()V 1
Label1:
.line 21
	return

.end method

.method public interfaceMethod()V
.limit stack 0
.limit locals 1
.var 0 is this Lcallgraphstat/JonasTestMain; from Label0 to Label0

Label0:
.line 25
	return

.end method
