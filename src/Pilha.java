import java.util.Arrays;
import java.util.Objects;

public class Pilha <X> {

    private Object[] elem;
    private int ultimo = -1;

    public Pilha(int tamanho)throws Exception{
        if(tamanho <= 0)
            throw new Exception("Tamanho Inválido");
        this.elem = new Object[tamanho];
    }

    public void GuardaUmIem(X x) throws Exception{
        if(this.ultimo == this.elem.length -1)
            throw new Exception("Não cabe");

        this.ultimo++;
        if(x instanceof Cloneable)
            this.elem[this.ultimo] = new Clonador<>().clone(x);
        else
            this.elem[this.ultimo] = x;
    }

    public X recuperaUmItem() throws Exception{
        if(this.ultimo == -1)
            throw new Exception("Pilha Vazia");
        if(this.elem[this.ultimo] instanceof Cloneable)
            //Conversão Do X dentro do Clone o InteliJ pediu <(\'_'/)>
            return new Clonador<X>().clone((X) this.elem[this.ultimo]);
        else
            return (X) this.elem[this.ultimo];
    }

    public void RetiraUmItem() throws Exception{
        if (this.ultimo == -1)
            throw new Exception("Pilha vazia");

        this.elem[this.ultimo] = null;
        this.ultimo--;
    }

    @Override
    public String toString() {
        if(this.ultimo == -1)
            return ("Pilha vazia");

        return ("Tem: " + (this.ultimo +1) + " elementos dentro da pilha, " +
                "sendo o ultimo valor inserido: " + this.elem[this.ultimo]);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;

        Pilha<X> pil = (Pilha<X>) obj;

        if(this.ultimo != pil.ultimo)
            return false;
        for(int i=0; i <= this.ultimo; i++)
            if(!this.elem[i].equals(pil.elem[i]))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        int ret = 666;
        ret = 7 * ret + new Integer(this.ultimo).hashCode();
        for(int i = 0; i <= this.ultimo; i++)
            ret = 13 * ret + this.elem[i].hashCode();
        if(ret < 0)
            ret = -ret;
        return ret;
    }

    public Pilha(Pilha<X> modelo) throws Exception{
        if(modelo == null)
            throw new Exception("Modelo Ausente");

        this.ultimo = modelo.ultimo;
        for(int i = 0; i <= modelo.ultimo; i++)
            this.elem[i] = modelo.elem[i];
    }

    public Object clone(){
        Pilha<X> ret = null;
        try {
            ret = new Pilha<X>(this);
        }
        catch (Exception erro)
        { }
        return ret;
    }
}