package br.com.jadson.models.vo.exercicio2;

public class NotasVO {
    private int id;
   private int pessoaid;
   private int vacinaid;

   NotasVO(){}

   public NotasVO(int id, int pessoaid, int vacinaid) {
       this.id = id;
       this.pessoaid = pessoaid;
       this.vacinaid = vacinaid;
   }

   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public int getPessoaid() {
       return pessoaid;
   }

   public void setPessoaid(int pessoaid) {
       this.pessoaid = pessoaid;
   }

   public int getVacinaid() {
       return vacinaid;
   }

   public void setVacinaid(int vacinaid) {
       this.vacinaid = vacinaid;
   }

   
   
}
