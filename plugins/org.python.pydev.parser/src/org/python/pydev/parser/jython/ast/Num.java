// Autogenerated AST node
package org.python.pydev.parser.jython.ast;
import org.python.pydev.parser.jython.SimpleNode;

public final class Num extends exprType implements num_typeType {
    public Object n;
    public int type;
    public String num;

    public Num(Object n, int type, String num) {
        this.n = n;
        this.type = type;
        this.num = num;
    }


    public Num createCopy() {
        return createCopy(true);
    }
    public Num createCopy(boolean copyComments) {
        Num temp = new Num(n, type, num);
        temp.beginLine = this.beginLine;
        temp.beginColumn = this.beginColumn;
        if(this.specialsBefore != null && copyComments){
            for(Object o:this.specialsBefore){
                if(o instanceof commentType){
                    commentType commentType = (commentType) o;
                    temp.getSpecialsBefore().add(commentType.createCopy(copyComments));
                }
            }
        }
        if(this.specialsAfter != null && copyComments){
            for(Object o:this.specialsAfter){
                if(o instanceof commentType){
                    commentType commentType = (commentType) o;
                    temp.getSpecialsAfter().add(commentType.createCopy(copyComments));
                }
            }
        }
        return temp;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("Num[");
        sb.append("n=");
        sb.append(dumpThis(this.n));
        sb.append(", ");
        sb.append("type=");
        sb.append(dumpThis(this.type, num_typeType.num_typeTypeNames));
        sb.append(", ");
        sb.append("num=");
        sb.append(dumpThis(this.num));
        sb.append("]");
        return sb.toString();
    }

    public Object accept(VisitorIF visitor) throws Exception {
        return visitor.visitNum(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
    }

}
