package Test.TestArbre;


import Arbre.Node;
import Arbre.PrettyPrintTree;

public class TestArbre {
	
	public static void main(String[] args){
        var root = new Node<String>("Programme");
        var fonction1 = root.addChild("Fonction");
        var idf1 = fonction1.addChild("fonction1");
        var param1 = fonction1.addChild("Paramètre(s)");
        var a1 = param1.addChild("a");
        var block1 = fonction1.addChild("Bloc");
        var return1 = block1.addChild("return");
        var moins1 = return1.addChild("-");
        var returna = moins1.addChild("a");
        

        var fonction2 = root.addChild("Fonction");
        var idf2 = fonction2.addChild("fonction2");
        var param2 = fonction2.addChild("Paramètre(s)");
        var a2 = param2.addChild("a");
        var b = param2.addChild("b");
        var block2 = fonction2.addChild("Bloc");
        var if2 = block2.addChild("if");
        var condition2 = if2.addChild("!=");
        var conA =condition2.addChild("a");
        var conB =condition2.addChild("b");
        var blocIf=if2.addChild("Bloc");
        var printCall = blocIf.addChild("print");
        var callF1 = printCall.addChild("fonction1(a)");
        var elsee=if2.addChild("else");
        var elseblock=elsee.addChild("Bloc");

        var if3=elseblock.addChild("if");
        var condif3=if3.addChild("==");
        var conAA =condif3.addChild("a");
        var conBB =condif3.addChild("b");
        var blocif3=if3.addChild("Bloc");
        var printif3=blocif3.addChild("print");
        var printnot=printif3.addChild("not");
        var nota=printnot.addChild("a");
        var else3=if3.addChild("else");
        var blocelse=else3.addChild("Bloc");
        var blocprint=blocelse.addChild("print");
        var truee=blocprint.addChild("True");
      
        
        var forr= root.addChild("for");
        var paramFor=forr.addChild("Paramètre(s)");
        var paramForI=paramFor.addChild("i");
        var in= forr.addChild("in");
        var tab= forr.addChild("[]");
        var un= tab.addChild("1");
        var deux= tab.addChild("2");
        var trois= tab.addChild("3");
        var blockFor= forr.addChild("Bloc");

        var conditionFor = blockFor.addChild("if");
        var condForI = conditionFor.addChild(">=");
        var condForILeft = condForI.addChild("i");
        var condForIRight = condForI.addChild("1");
        var blockIfFor = conditionFor.addChild("Bloc");
        var printIfFor = blockIfFor.addChild("print");
        var printMessage1 = printIfFor.addChild("\"Valeur supérieure à 1\"");
        
        
        var elseFor = conditionFor.addChild("else");
        var blockElseFor = elseFor.addChild("Bloc");
        var printElseFor = blockElseFor.addChild("print");
        var printMessage2 = printElseFor.addChild("\"Valeur égale à 1\"");
        
        var x = root.addChild("=");
        var xx = x.addChild("x");
        var valueX = x.addChild("-10");
        var y = root.addChild("=");
        var yy = y.addChild("y");
        var operationY = y.addChild("//");
        var leftOperandY = operationY.addChild("x");
        var rightOperandY = operationY.addChild("+");
        var deuxx=rightOperandY.addChild("2");
        var troiss=rightOperandY.addChild("3");
        var z = root.addChild("=");
        var zz = z.addChild("z");
        var callFunction1 = z.addChild("fonction1(x)");
        
        var pt = new PrettyPrintTree<Node<String>>(
                Node::getChildren,
                Node::getValueToString
        );
        pt.display(root);
        
    }

}
