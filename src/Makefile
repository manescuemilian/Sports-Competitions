JFLAGS = -g
JC = javac
JVM= java
.SUFFIXES: .java .class
.java.class:
	$(JC) -Xlint:unchecked $(JFLAGS) $*.java

CLASSES = \
		Team.java \
		HandballTeam.java \
		FootballTeam.java \
		BasketballTeam.java \
		Player.java \
		TeamFactory.java \
		Competition.java \
		TeamVisitor.java \
		Visitor.java \
		Visitable.java \
		Ranking.java \
		Observer.java \
		Context.java \
		CalculateFootball.java \
		CalculateHandball.java \
		CalculateBasketball.java \
		Strategy.java \
		Main.java 

MAIN = Main

default: classes

classes: $(CLASSES:.java=.class)

run: classes
	$(JVM) $(MAIN) ${COMANDA} ${IN1} ${IN2} ${OUT}

clean:
	rm *.class
