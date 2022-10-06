package ProjetoFila;

public class Fila1<T> {

    private No<T> refNoEntradaFila;

    public Fila1(){
        this.refNoEntradaFila = null;
    }

    public void enqueue(T object){
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila); // novo nó passando sendo o ultimo nó
        refNoEntradaFila = novoNo; // referencia do antigo nó passa ser penultimo nó
    }


    public T dequeue(){
        if (!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while (true){
                if (primeiroNo.getRefNo() != null){
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    noAuxiliar.setRefNo(null);
                    break;
                }
            }
            return (T) primeiroNo.getObject(); //(T) key
        }
        return null;
    }



    public T primeiro(){
        if (!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            while (true){
                if (primeiroNo.getRefNo() != null){  //Caso se primeiroNo não for primeiro vai dar break
                    primeiroNo = primeiroNo.getRefNo(); // se for passa ser primeiro nó
                }else {
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }

    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
        String stringRetorno = " ";
        No noAuxiliar = refNoEntradaFila;

        if (refNoEntradaFila != null){
            while (true) {
                stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";

                if (noAuxiliar.getRefNo() != null) {
                    noAuxiliar = noAuxiliar.getRefNo();
                } else {
                    stringRetorno += "null";
                    break;
                }
            }

        }else {
            stringRetorno = "null";
        }
        return stringRetorno;
    }
}
