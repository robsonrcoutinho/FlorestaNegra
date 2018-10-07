import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta é a classe base para todos os inimigos
 * ela fornce funcionalidades específicas,
 * como verificar colisão com o cenário, com o ator
 * principal e com os limites do cenário.
  
 * @since Novembro 2013.
 */
public abstract class Inimigos extends Actor implements Dano
{
    /**
     * Nesse constutor é adicionado
     * o número de série ao objeto. 
     */ 
    public Inimigos(){
        numero++;
        numeroDeSerie=numero;
        valorDano2Padrao=2;
    }
    
    public void gravidade()
    {
        if(!isTouching(Base.class)){
            if(podeDescer==true)
                setLocation(getX(),getY()+6);
        }
        
        if(isTouching(Base.class)){
            chao=getOneIntersectingObject(Base.class);
            if(getY()>chao.getY()+2)
                setLocation(getX(),getY()+4);
        }
    }
    
    /**
     * Este método verifica se o ator
     * atingiu algum objeto Players.
     * @return Actor - Caso ele colida com um jogador ele retorna o mesmo, do contrário retorna null.
     */
    public Actor colisao(){
       possivelColisor = getOneIntersectingObject(Jogador.class);
        
       if(possivelColisor!=null){
            ataque=true;
            return possivelColisor;
        
        }else{
            colisaoCenario();
            return null;
        }
    }
        
    /**
     * Este método verifica se o ator
     * colidiu com alguma caixa.
     */
    public void colisaoCenario(){
        possivelColisor = getOneIntersectingObject(Terrain.class);
        if(possivelColisor!=null)
            moveBack=true;   
        
        if(limitesCenario()==true){
           moveBack=true;
        }    
    }
    
   /**
    * Verifica se os ator
    * atingiu o limite so cenário.
    * @return boolean - true se o personagem atingiu o limite da tela nos eixos X e Y, do contrário retorna false.
    */ 
    public boolean limitesCenario(){
       if(getX()<(getWorld().getWidth())-(getWorld().getWidth()))
            parar=true;
        else 
            parar=false;
    
       if(getX()>getWorld().getWidth())
            parar=true;
         else
            parar=false;
         
       if(getX()<(getWorld().getWidth())-(getWorld().getWidth()+1))
           return true;
        
       if(getX()>getWorld().getWidth()-1)
           return true;
       
          return false;    
    }
    
    /**
     * Atribui dano a este ator.
     */
    public void dano()
     {
         this.dano=true;
    }  
    
    public void dano2(){
        this.dano2=true;
    }
    
    /**
     * Retorna o número de série do ator
     * @return int - retornando  o número de série. 
     */
    public int getNumeroDeSerie(){
        return this.numeroDeSerie;
    }
    
    /**
     * Método sobrescrito
     * caso ele seja instancia de inimigos e o numeroDeSerie do ator seja igual
     * ao do outro inimigo ele consdira que seja o mesmo
     * objeto.
     * @param obj , qualquer objeto.
     * @return boolean - true se o objeto passado for instância de Inimigos e tiverem o mesmo numeroDeSerie, do contrário retorna false.
     */
    public boolean equals(Object obj){
        if(obj instanceof Inimigos)
            return (numeroDeSerie==((Inimigos)obj).getNumeroDeSerie());
            else
            return false;
    }
    
    public Actor getPersonagemPrincipal(){
        return ((MoveMundo)getWorld()).getPersonagemPrincipal();
    }
    
    public void setAlturaPadrao(int alturaPadrao){
        this.alturaPadrao=alturaPadrao;
    }
    
    public int getAlturaPadrao(){
        return this.alturaPadrao;
    }
    
   protected boolean moveBack;
   protected boolean dano;
   protected boolean dano2;
   protected boolean parar=false; 
   
   protected int valorDano2Padrao;
   protected boolean ataque;
   protected int frameImage;
   protected Actor possivelColisor;
   private Actor chao;
   public static int numero=0;
   protected int numeroDeSerie;
   public boolean podeDescer=true;
   protected Vidas hp;
   private int alturaPadrao;
}
