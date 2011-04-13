// Autogenerated AST node
package org.python.pydev.parser.jython.ast;
import org.python.pydev.parser.jython.SimpleNode;

public final class Slice extends sliceType {
    public exprType lower;
    public exprType upper;
    public exprType step;

    public Slice(exprType lower, exprType upper, exprType step) {
        this.lower = lower;
        this.upper = upper;
        this.step = step;
    }


    public Slice createCopy() {
        return createCopy(true);
    }
    public Slice createCopy(boolean copyComments) {
        Slice temp = new Slice(lower!=null?(exprType)lower.createCopy(copyComments):null,
        upper!=null?(exprType)upper.createCopy(copyComments):null,
        step!=null?(exprType)step.createCopy(copyComments):null);
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
        StringBuffer sb = new StringBuffer("Slice[");
        sb.append("lower=");
        sb.append(dumpThis(this.lower));
        sb.append(", ");
        sb.append("upper=");
        sb.append(dumpThis(this.upper));
        sb.append(", ");
        sb.append("step=");
        sb.append(dumpThis(this.step));
        sb.append("]");
        return sb.toString();
    }

    public Object accept(VisitorIF visitor) throws Exception {
        return visitor.visitSlice(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
        if (lower != null){
            lower.accept(visitor);
        }
        if (upper != null){
            upper.accept(visitor);
        }
        if (step != null){
            step.accept(visitor);
        }
    }

}
