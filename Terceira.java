import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Esta classe referente a terceira fase 
 * do jogo.
 * 
 * @since Novembro, 2013.
 */
public class Terceira extends MoveMundo
{
    /**
     * No construtor é adicionado ao mundo
     * alguns objetos, como também é redimensionado e 
     * setado a imagem de fundo no mundo.
     */
    public Terceira()
    {    
         super(800, 400, 600);
         img.scale(800,400);
         setBackground(img);
         adicionarObjeto(new Base(4000,20,new GreenfootImage("ImpossibleBlock.png")),getWidth()-getWidth(),getHeight()-10,true);
         adicionarObjeto(new Base(370,5,new GreenfootImage("Blank.png")),getWidth()-184,getHeight()-93,true);
         adicionarObjeto(new Base(65,5,new GreenfootImage("Blank.png")),getWidth()-295,getHeight()-115,true);
         adicionarObjeto(new Base(65,5,new GreenfootImage("Blank.png")),getWidth()-70,getHeight()-140,true);
         adicionarObjeto(new Base(70,5,new GreenfootImage("Blank.png")),getWidth()-484,getHeight()-70,true);
         adicionarObjeto(new Base(65,5,new GreenfootImage("Blank.png")),getWidth()-600,getHeight()-102,true);
         adicionarObjeto(new Base(70,5,new GreenfootImage("Blank.png")),getWidth()-710,getHeight()-68,true);
         adicionarObjeto(new Base(30,5,new GreenfootImage("Blank.png")),getWidth()-785,getHeight()-120,true);
         adicionarObjeto(new Base(102,5,new GreenfootImage("Blank.png")),getWidth()-695,getHeight()-183,true);
         
         adicionarPersonagemPrincipal(new Oberon(), 150, getHeight()-95, 100); 
         adicionarObjeto(new Inimigo07(), 300, getHeight()-240,false);
            adicionarConjuntoOrbs();
    
    }  
    
    public void adicionarConjuntoOrbs(){
         for(int x=0;x<orbe.length;x++)
            orbe[x] = new Orbe();
         
         for(int x=0;x<orbe.length;x++)
            orbe[x].pararDePiscar();
         
         adicionarObjeto(orbe[0], 365, getHeight()-275,false);
         adicionarObjeto(orbe[1], 365, getHeight()-205,false);
         adicionarObjeto(orbe[2], 300, getHeight()-150,false);
         adicionarObjeto(orbe[3], 300, getHeight()-340, false);
         adicionarObjeto(orbe[4], 236, getHeight()-275,false); 
         adicionarObjeto(orbe[5], 236, getHeight()-205,false);   
    }
    
    /**
     * Este método é chamado pela estrutura do greenfoot,
     * realizando todas as ações deste ator.
     */    
    public void act(){
        moverMundo();
      Oberon ob=(Oberon)getPersonagemPrincipal();
       if(objetivoCompleto())
            proximoMundo();
       if(Greenfoot.isKeyDown("p"))        
            pause(); 
       if(inimigosEvocados==6)
         for(int x=0;x<orbe.length;x++)
            orbe[x].acender();
            
    }
    
    /**
     * Verifica se o objetivo desse estágio foi cumprido, caso foi ele retorna true, do contrário retorna false.
     * @return boolean
     */
    public boolean objetivoCompleto(){
        objs=getObjects(Inimigo07.class);
        return objs.isEmpty();
    }
    
    /**
     * Adiciona um personagem escolhido aleatoriamente, em um local aleatório.
     */
    public void adicionarPersonagemAleatorio(){
        int aleatorio=Greenfoot.getRandomNumber(8);
        inimigosEvocados++;
        if(aleatorio==0)
            adicionarNaBasePrincipal(new Inimigo01());
        if(aleatorio==1)
            adicionarEmLocalAleatorio(new Inimigo02());
        if(aleatorio==2)
            adicionarEmLocalAleatorio(new Inimigo03());
        if(aleatorio==3)
            adicionarNaBasePrincipal(new Inimigo04());
        if(aleatorio==4)
            adicionarNaBasePrincipal(new Inimigo05());
        if(aleatorio==5)
            adicionarNaBasePrincipal(new Inimigo06());
        if(aleatorio==6)
            adicionarNaBasePrincipal(new Inimigo08());
        if(aleatorio==7)
            adicionarEmLocalAleatorio(new Inimigo10());
    }
    
    /**
     * Este método é responsável por adicionar um
     * adicionar um personagem em um local aleatório
     * @param k - ator a ser adiciona em um local aleatório.
     */
    private void adicionarEmLocalAleatorio(Inimigos k){
        int aleatorio = Greenfoot.getRandomNumber(9);
        adicionarObjeto(k,coordenadas[aleatorio].getX(), coordenadas[aleatorio].getY(),false);
    }
    
    private void adicionarNaBasePrincipal(Inimigos k){
        int aleatorio = Greenfoot.getRandomNumber(3);
        adicionarObjeto(k,coordenadas2[aleatorio].getX(), coordenadas2[aleatorio].getY()-k.getAlturaPadrao(),false);
    }
     
    /**
     * Este método é responsável por setar
     * o próximo mundo.
     */
    public void proximoMundo(){
        World load =  new EstagioCompleto(new Apocalipse());
        Greenfoot.setWorld(load);
    }
    
    public void reiniciarTotalmente(){
        Greenfoot.setWorld(new Terceira());
    }
    
    public void pause(){
        Greenfoot.setWorld(new Pause(this));
    }
    
    public void continuar(){
        Greenfoot.setWorld(this);
    }
    
    public int verificaInimigosVivos(){
        inimigosVivos=getObjects(Inimigos.class);
        return inimigosVivos.size();
    }
    
    private GreenfootImage img = new GreenfootImage("fase3.jpg");
    
    private Coordenadas [] coordenadas= {new Coordenadas(), new Coordenadas(getWidth()-184,getHeight()-93),
    new Coordenadas(getWidth()-295,getHeight()-115),new Coordenadas(getWidth()-70,getHeight()-140),new Coordenadas(getWidth()-484,getHeight()-70),
    new Coordenadas(getWidth()-600,getHeight()-102),new Coordenadas(getWidth()-710,getHeight()-68),new Coordenadas(getWidth()-785,getHeight()-120),
    new Coordenadas(getWidth()-695,getHeight()-183)};
    
    private Coordenadas[] coordenadas2={new Coordenadas(600, getHeight()),new Coordenadas(200, getHeight()),
        new Coordenadas(400, getHeight())};
    
    private List objs;
    private List inimigosVivos;
    private int inimigosEvocados;
    private Orbe[] orbe = new Orbe [6];
}
