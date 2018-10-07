import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referente a primeira fase do jogo
 * 
 * @since Novembro, 2013.
 */
public class Primeira extends MoveMundo
{
    /**
     * No construtor é adicionado objetos ao mundo,
     * e também é redimensionado e adicionado a imagem
     * de fundo ao mundo.
     */
    public Primeira()    
    {    
           
         super(800, 400, 5200);        
         img.scale(800, 400);
         setBackground(img);
        
         
      adicionarObjeto(new Base(11000,20,new GreenfootImage("ImpossibleBlock.png")),getWidth()-getWidth(),getHeight()-10,true);
      adicionarPersonagemPrincipal(new Oberon(), 150, getHeight()-95, 300);  
      
      adicionarObjeto(new Box(),2000,getHeight()-45,true);
      adicionarObjeto(new Box(),2090,getHeight()-145,true);
      adicionarObjeto(new Box(),2210,getHeight()-145,true);
      adicionarObjeto(new Box(),2340,getHeight()-145,true);
      adicionarObjeto(new Box(),2440,getHeight()-145,true);
      adicionarObjeto(new Box(),2540,getHeight()-145,true);
      adicionarObjeto(new Box(),2440,getHeight()-145,true);
      adicionarObjeto(new Box(),2540,getHeight()-145,true);
      adicionarObjeto(new Box(),2640,getHeight()-145,true);
      adicionarObjeto(new Box(),2740,getHeight()-145,true);
      
      adicionarObjeto(new Spike(), 2050, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2075, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2100, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2125, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2150, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2175, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2200, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2225, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2250, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2275, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2300, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2325, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2350, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2375, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2400, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2425, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2450, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2475, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2500, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2525, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2550, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2575, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2600, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2625, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2650, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2675, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2700, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2725, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2750, getHeight()-33, true);
      adicionarObjeto(new Spike(), 2775, getHeight()-33, true);
      
      
      adicionarObjeto(new Inimigo08(),520,getHeight()-55, true);
      adicionarObjeto(new Inimigo02(),1500,getHeight()-45, true);
      adicionarObjeto(new Inimigo02(),2540,getHeight()-190, true);
      
      adicionarObjeto(new Inimigo08(),1000, getHeight()-45,true);
      
      adicionarObjeto(new Inimigo03(),2850,getHeight()-32 , true);        
      adicionarObjeto(new Inimigo03(),2865,getHeight()-32 , true);
      adicionarObjeto(new Inimigo03(),2880,getHeight()-32 , true);
      
      adicionarObjeto(new Totem(),2973, getHeight()-145,true);
      adicionarBlocoEspetado(3050,getHeight()-145);
      adicionarBlocoEspetado(3100,getHeight()-145);
      adicionarObjeto(new Totem(), 3170, getHeight()-145, true);
      adicionarBlocoEspetado(3250,getHeight()-145);
      adicionarObjeto(new Totem(), 3340, getHeight()-145, true);
      adicionarBlocoEspetado(3420, getHeight()-145);
      adicionarObjeto(new Totem(),3510, getHeight()-145, true);
      adicionarBlocoEspetado(3590, getHeight()-145);
      adicionarObjeto(new Totem(), 3680, getHeight()-145, true);
      adicionarBlocoEspetado(3760, getHeight()-145);
      adicionarObjeto(new Totem(), 3850, getHeight()-145, true);
      adicionarBlocoEspetado(3930, getHeight()-145);
      adicionarObjeto(new Totem(), 4020, getHeight()-145, true);
      adicionarBlocoEspetado(4100, getHeight()-145);
      adicionarBlocoEspetado(4150,getHeight()-145);
      adicionarBlocoEspetado(4200,getHeight()-145);
      adicionarBlocoEspetado(4250,getHeight()-145);
      adicionarBlocoEspetado(4300,getHeight()-145);
      adicionarBlocoEspetado(4350,getHeight()-145);
      adicionarBlocoEspetado(4400,getHeight()-145);
      adicionarBlocoEspetado(4450,getHeight()-145);
      adicionarBlocoEspetado(4500,getHeight()-145);
      adicionarBlocoEspetado(4550,getHeight()-145);
      adicionarBlocoEspetado(4600,getHeight()-145);
      adicionarBlocoEspetado(4650,getHeight()-145);
      adicionarBlocoEspetado(4700,getHeight()-145);
      adicionarBlocoEspetado(4750,getHeight()-145);
      adicionarBlocoEspetado(4800,getHeight()-145);
      adicionarBlocoEspetado(4850,getHeight()-145);
      adicionarBlocoEspetado(4900,getHeight()-145);
      adicionarBlocoEspetado(4950,getHeight()-145);
      
      adicionarObjeto(new Inimigo02(), 5150, getHeight()-45,true);
      adicionarObjeto(orbe, 5280, getHeight()-45, true);
      
      adicionarObjeto(new Box(),5323,getHeight()-45,true);
      adicionarObjeto(new Box(),5323,getHeight()-90,true);
      adicionarObjeto(new Box(),5323,getHeight()-135,true);
      adicionarObjeto(new Box(),5323,getHeight()-180,true);
      adicionarObjeto(new Box(),5323, getHeight()-225,true);
      adicionarObjeto(new Box(),5323, getHeight()-270,true);
      
      adicionarBloqueio();
      
      adicionarObjeto(new Base(1200,20,new GreenfootImage("ImpossibleBlock.png")),4700,getHeight()-285,true);
      
       
    }       
       
      
    public void adicionarBlocoEspetado(int x, int y){
            adicionarObjeto(new Box(),x,y,true);
            adicionarObjeto(new Spike(), x+12, y-37,true);
            adicionarObjeto(new Spike(), x-13, y-37,true);
            adicionarObjeto(new Spike(180), x+12, y+37,true);
            adicionarObjeto(new Spike(180), x-13, y+37,true);
    }
    
    public void adicionarBloqueio(){
        
        for(int x=0;x<bloqueio.length;x++)
            bloqueio[x]=new Box();
        
        adicionarObjeto(bloqueio[0], 5323, getHeight()-315,true);
        adicionarObjeto(bloqueio[1], 5323, getHeight()-360,true);
        adicionarObjeto(bloqueio[2], 5323, getHeight()-405,true);
        adicionarObjeto(bloqueio[3], 5323, getHeight()-450,true);
    }
    
    public void removerBloqueio(){
        for(int x=0;x<bloqueio.length;x++)
            removerObjeto(bloqueio[x]);
    }
     
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo. Nele também chamados o método moverMundo()
     * da super classe, responsável por mover o mundo.
     */
    public void act(){        
        moverMundo();        
        Oberon ob=(Oberon)getPersonagemPrincipal();
        //Se Oberon não morreu alcançou o fim da tela e o número de Inimigos for igual a 0
        //Ele pode passar de fase.
        if(getPersonagemPrincipal().getX()>getWidth()-10)//&&numberOfObjects()==5)         
                proximoMundo();
        
        if(Greenfoot.isKeyDown("p"))        
            pause();
        
        if(orbeRemovida==false){
            if(orbe.sendoTocado(Oberon.class)){
                removerBloqueio();
                removerObjeto(orbe);
                orbeRemovida=true;
            }
        }
        
    }
    
    /**
     * Esse método através do método setWorld()
     * de Greenfoot, seta o próximo mundo
     */
    public void proximoMundo(){
        World load =  new EstagioCompleto(new Segunda());
        Greenfoot.setWorld(load);
    }
    
    public void reiniciarTotalmente(){
        Greenfoot.setWorld(new Primeira());
    }
   
    public void pause(){
        Greenfoot.setWorld(new Pause(this));
    }
    
    public void continuar(){
        Greenfoot.setWorld(this);        
    }   
    
    
    
    /** Imagem da fase*/
    private GreenfootImage img = new GreenfootImage("Cenario1.jpg");
    private  GreenfootSound somFundoPrimeira = new GreenfootSound("somFundo.mp3");    
    private Box [] bloqueio = new Box[4];
    private Orbe orbe = new Orbe();
    private boolean orbeRemovida;
}
