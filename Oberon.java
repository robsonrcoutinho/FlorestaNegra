import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referente ao ator principal
 * Ela possui métodos que fazem o ator andar, mover
 * atirar, perder vida, bater e reviver.
 * @since Novembro 2013.
 */
public class Oberon extends Jogador
{
   /**
    * Nesse construtor é invertido a imagem de Oberon
    */
    public Oberon()
    {
        inverterImagem();
   }
   
   /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     * @param world
     */
    public void addedToWorld(World world)
    {
        setImage(quadrosOberon[0]);
        getWorld().addObject(ob, getX()-20, getY()-290); 
        ((MoveMundo)getWorld()).adicionarObjeto(energia, getX()+176  , getY()-290,false);//85 260
        ((MoveMundo)getWorld()).adicionarObjeto(qtdVidas, getX()-85 , getY()-260,false);//45 260
    }
    
   /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */
   public void act() 
    {
        if(pausado==false){
            if(!morreu()){
                levouDano();
                colisao();
                gravidade();
                direcao();
            }
        }   
    }    
   
   /**
     * Este método verifica se o ator levou dano
     * caso tenha levado ele diminui o número de pontos
     * de vida.
     */
   public void levouDano()
    {
        if(dano==true){
            ob.perderPontoVida();
            dano=false;
        }
        if(getY()>=getWorld().getHeight()-1)
            ob.perderTodaVida();
    }
    
   /**
     * Este método verifica se o ator morreu
     * caso tenha morrido, ele diminui a quantidade 
     * de vidas.
     * @return boolean - true se o personagem morreu, do contrário retorna false.
     */
   public boolean morreu()
    {
        if(ob.getPontoVida()<=0){
            qtdVidas.diminuirVidas();
            dano=false;
            if(qtdVidas.getVidas()>0){
                ob.recuperarTodaVida();
                energia.recuperarTodaEnergia();
            }
            return true;
        }else
            return false;
    }
    
   /**
    * Este método é responsável por fornecer a
    * direção ao ator, como também controlar a
    * posição das imagens.
    */ 
   private void direcao()
   {
       if(Greenfoot.isKeyDown("a")&&pulando==false)
       {
           if(direita==true){
              inverterImagem();
                if(podeAndarEsquerda==true){
                    move(1);
                    direita=false;
                
                }else{
                    frame();
                    direita=false;
                }
            }
            else{
                if(podeAndarEsquerda==true){
                  move(1);
                }else{
                    frame();
                } 
            }
       }
       if(Greenfoot.isKeyDown("d")&&pulando==false){
           if(direita==false){
               inverterImagem();
            if(podeAndarDireita==true){
                    move(2);
                    direita=true;
                
                }else{
                    frame();
                    direita=true;
                }}
            else{
                if(podeAndarDireita==true){
                    move(2);
                    direita=true;
                
                }else{
                    frame();
                    direita=true;
                }
               }
            }
       if(Greenfoot.isKeyDown("j")&&pulando==false)
            move(3);
         String k = Greenfoot.getKey();   
       if(k!=null&&k.equals("k"))
            atira();
    
       if(Greenfoot.isKeyDown("l"))
            bate();
   }
   
   /**
   * Este método é responsável por mover o 
   * ator na direção desejada.
   * @param direcao - esse inteiro representa a direção na qual o personagem deve se mover. 1 Esquerda, 2 Direita 3 Salto.
   */ 
   public void move(int direcao)
   {
        switch (direcao){
   
        case 1: setLocation(getX()-2, getY());//move a esquerda
                frame();
                 break;
        case 2: setLocation(getX()+2, getY());//move para direita
                frame();
                break;
        case 3:     
                    alturaNoMomentoDoSalto = getY();
                    pular();
        break;
       }
   }
   
   /**
    * Este método é responsável por realizar o pulo do ator
    */
   private void pular(){
       if(podePular==true)
       { 
           if(podeSubir=true){
               colisao();
               podePular=false;
               pulando=true; 
           
               setLocation(getX(), getY()-1);
               if(getY()>=alturaNoMomentoDoSalto+alturaMaximaDoPulo&&podeSubir==true){
                   podePular=true;
                   pular();
               }else{
                    pulando=false;
               }
            }else 
                return;
            }
   }
   
    /**
    * Este método adiciona o tiro no mundo, e 
    * diminui a energia.
    */
   private void atira(){
       if(direita==false&&energia.getEnergia()>0){
                ((MoveMundo)getWorld()).adicionarObjeto(new TiroBesta(direita), getX()-25, getY()-5,false);
                energia.diminuirEnergia();
            }else{
                if(energia.getEnergia()>0){
                ((MoveMundo)getWorld()).adicionarObjeto(new TiroBesta(direita), getX()+25, getY()-5,false);
                energia.diminuirEnergia();
            }
        }
        }
    
   /**
    * Este método é responsável por
    * bater no ator
    */     
   private void bate(){
       if(direita==false){
                if(tempoAteProximoDano==0){
                ((MoveMundo)getWorld()).adicionarObjeto(new Espada(), getX()-25, getY(),false);
                tempoAteProximoDano=20;
            }
        }else 
           if(tempoAteProximoDano==0){
                ((MoveMundo)getWorld()).adicionarObjeto(new Espada(), getX()+25, getY(),false);
                tempoAteProximoDano=20;
            }
       
       if(tempoAteProximoDano!=0)
            tempoAteProximoDano--;
   
    }
   
    /**
    *  Este método é responsável por
    *  exibir o frame do ator.
    */
   private void frame()
    {
        if(movimentaFrame%10==0)
        setImage(quadrosOberon[movimentaFrame/10]);
        
        if(movimentaFrame==41)
        movimentaFrame=-1;
        
        movimentaFrame++;
    }
  
    /**
     * Este método é responsável por inverter a imagem do 
     * ator.
     */
   private void inverterImagem()
    {
        for(int i=0;i<quadrosOberon.length;i++)
            quadrosOberon[i].mirrorHorizontally();
   }
   
   public void pausar(){
       pausado=true;
   }
   
   public void despausar(){
       pausado=false;
   } 
        
        private GreenfootImage[] quadrosOberon ={new GreenfootImage("ob0.png"),new GreenfootImage("ob1.png"),new GreenfootImage("ob2.png"),new GreenfootImage("ob3.png"),
        new GreenfootImage("ob4.png")};
       
        private OberonVida ob = new OberonVida();
        private QuantidadeVidas qtdVidas= new QuantidadeVidas();
        
        private boolean estaInvencivel;
        private boolean pausado;
        
        private int movimentaFrame;
        private int alturaNoMomentoDoSalto;
        private int tempoAteProximoDano;
       
}
