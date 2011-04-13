// Autogenerated AST node
package org.python.pydev.parser.jython.ast;
import org.python.pydev.parser.jython.SimpleNode;

public final class BoolOp extends exprType implements boolopType {
    public int op;
    public exprType[] values;

    public BoolOp(int op, exprType[] values) {
        this.op = op;
        this.values = values;
    }


    public BoolOp createCopy() {
        return createCopy(true);
    }
    public BoolOp createCopy(boolean copyComments) {
        exprType[] new0;
        if(this.values != null){
        new0 = new exprType[this.values.length];
        for(int i=0;i<this.values.length;i++){
            new0[i] = (exprType) (this.values[i] != null?
            this.values[i].createCopy(copyComments):null);
        }
        }else{
            new0 = this.values;
        }
        BoolOp temp = new BoolOp(op, new0);
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
        StringBuffer sb = new StringBuffer("BoolOp[");
        sb.append("op=");
        sb.append(dumpThis(this.op, boolopType.boolopTypeNames));
        sb.append(", ");
        sb.append("values=");
        sb.append(dumpThis(this.values));
        sb.append("]");
        return sb.toString();
    }

    public Object accept(VisitorIF visitor) throws Exception {
        return visitor.visitBoolOp(this);
    }

    public void traverse(VisitorIF visitor) throws Exception {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                if (values[i] != null){
                    values[i].accept(visitor);
                }
            }
        }
    }

}
