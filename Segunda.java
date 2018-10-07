import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referente a segunda fase do jogo.
 * 
 * @since Novembro, 2013.
 */
public class Segunda extends MoveMundo
{
    /**
    * No construtor é adicionado alguns objetos,
    * redimensionado a imagem de fundo e setado ao mundo.
    */
    public Segunda()
    {    
         // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(800, 400, 4000);
         img.scale(800, 400);
         setBackground(img);
         adicionarObjeto(new Base(4800,20,new GreenfootImage("ImpossibleBlock.png")), 2400, getHeight()-10, true);
         adicionarPersonagemPrincipal(new Oberon(), 150, getHeight()-95, 300);
         adicionarObjeto(new Inimigo02(), 400, getHeight()-45, true);
         
         adicionarBlocoEspetado2(670, getHeight()-115);   
         adicionarBlocoEspetado(800, getHeight()-45);
         adicionarBlocoEspetado5(800, getHeight()-95);
         adicionarBlocoEspetado4(1200, getHeight()-115);
         
         adicionarObjeto(new Inimigo01(), 900, getHeight()-45, true);
         adicionarObjeto(new Inimigo01(), 1200, getHeight()-45, true);
                
         adicionarBlocoEspetado(1600, getHeight()-45);
         adicionarBlocoEspetado5(1600, getHeight()-95);
         
         adicionarObjeto(new Inimigo03(), 1800, getHeight()-35, true);
         adicionarObjeto(new Inimigo03(), 1850,getHeight()-35, true);
         adicionarObjeto(new Inimigo02(), 2100, getHeight()-45, true);
         adicionarObjeto(new Totem(), 2500, getHeight()-145, true);
         adicionarBlocoEspetado(2600, getHeight()-45);
         adicionarBlocoEspetado(2600, getHeight()-95);
         adicionarBlocoEspetado(2600, getHeight()-135);
         adicionarBlocoEspetado(2600, getHeight()-185);
         adicionarObjeto(new Box(), 2600, getHeight()-225, true);
         
         adicionarObjeto(new Inimigo10(),3000, getHeight() -45, true);
         adicionarObjeto(new Totem(),3520, getHeight()-145, true);
         adicionarObjeto(new Box(), 3600, getHeight()-45, true);
         adicionarObjeto(new Box(), 3600, getHeight()-95, true);
         adicionarObjeto(new Box(), 3600, getHeight()-135, true);
         adicionarObjeto(new Box(), 3600, getHeight()-185, true);
         
         adicionarBlocoEspetado3(3520, getHeight()-315);
         adicionarBlocoEspetado3(3570, getHeight()-315);
         adicionarBlocoEspetado3(3620, getHeight()-315);
         adicionarBlocoEspetado3(3670, getHeight()-315);
         adicionarBlocoEspetado3(3620, getHeight()-315);
         
    }
    
    public void adicionarBlocoEspetado(int x, int y){
        adicionarObjeto(new Box(), x , y, true);
        adicionarObjeto(new Spike(270), x-37, y+12, true); 
        adicionarObjeto(new Spike(270), x-37, y-13, true);
        adicionarObjeto(new Spike(90), x+37, y+12, true); 
        adicionarObjeto(new Spike(90), x+37, y-13, true);
    }
    
    public void adicionarBlocoEspetado2(int x, int y){
        adicionarObjeto(new Box(), x, y, true);
        adicionarObjeto(new Spike(270), x-37, y+12,true); 
        adicionarObjeto(new Spike(270), x-37, y-13,true);
        adicionarObjeto(new Spike(), x-13, y-37,true);
        adicionarObjeto(new Spike(180), x-13, y+37,true);
    }
    
    public void adicionarBlocoEspetado3(int x, int y){
         adicionarObjeto(new Box(), x, y, true);
         adicionarObjeto(new Spike(), x+12, y-37,true);
         adicionarObjeto(new Spike(), x-13, y-37,true);
         adicionarObjeto(new Spike(180), x+12, y+37,true);
         adicionarObjeto(new Spike(180), x-13, y+37,true);
    }
    
    public void adicionarBlocoEspetado4(int x, int y){
        adicionarObjeto(new Box(), x, y, true);
        adicionarObjeto(new Spike(180), x+12, y+37,true);
        adicionarObjeto(new Spike(), x+12, y-37,true);
        adicionarObjeto(new Spike(90), x+37, y+12,true); 
        adicionarObjeto(new Spike(90), x+37, y-13,true); 
    }
    
    public void adicionarBlocoEspetado5(int x, int y){
        adicionarObjeto(new Box(), x, y, true);
        adicionarObjeto(new Spike(270), x-37, y+12,true);
        adicionarObjeto(new Spike(90), x+37, y+12,true);
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     */
     public void act(){
         moverMundo();
         Oberon ob=(Oberon)getPersonagemPrincipal();
          if(getPersonagemPrincipal().getX()>getWidth()-10)         
                proximoMundo();
          if(Greenfoot.isKeyDown("p"))        
            pause();      
    } 
    
    public void proximoMundo(){
         World load =  new EstagioCompleto(new Terceira());
         Greenfoot.setWorld(load);
    }
    
    public void reiniciarTotalmente(){
        Greenfoot.setWorld(new Segunda());
    }
  
    public void pause(){
        Greenfoot.setWorld(new Pause(this));
    }
    
    public void continuar(){
        Greenfoot.setWorld(this);
    }
    
    private Actor x;
    private GreenfootImage img = new GreenfootImage("Cenario2.jpg");
}
