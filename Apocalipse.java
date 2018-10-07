import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referente a fase apocalipse
 * 
 * @since Novembro, 2013.
 */
public class Apocalipse extends MoveMundo
{
    /**
     * No construtor é adicionado alguns objetos,
     * redimensionado e adicionado o plano de fundo ao mundo.
     */
    public Apocalipse()
    {    
        super(800, 400,800);
        img.scale(800,400);
        setBackground(img);
        
        ob.pausar();
        elevador.pausar();
        
        adicionarObjeto(new Base(4000,10,new GreenfootImage("Blank.png")),getWidth()/2,getHeight(),false);
        adicionarPersonagemPrincipal(ob, 150, getHeight()-95, 0); 
        adicionarObjeto(chefao,600, getHeight()-180, false);
    }
    
    /**
     * Este método é chamado pelo sistema
     * do greenfoot quando  o ator é inserido
     * no mundo.
     */
    public void act(){
        if(Greenfoot.isKeyDown("p"))        
            pause();
            
        moverMundo();
        comeco();
        finaliza(); 
        if(faseConcluida){
            Greenfoot.setWorld(new Finalizacao());
        }
    }
    
    private void comeco(){
        if(comeco==false){
            if(chefao.getPasso1Completo()){
                ob.despausar();
                elevador.despausar();
                adicionarObjeto(elevador, 25,getHeight()-35,false);
                comeco=true;
            }
        }
    }
    
    private void finaliza(){
        if(finaliza==false){
            if(chefao.getFrameMorrendoCompleto()){
                removerObjeto(elevador);
                adicionarObjeto(new florDeSangue(), 25, getHeight()-25,false);
                finaliza=true;
            }
        }
    }
    
    public void reiniciarTotalmente(){
        Greenfoot.setWorld(new Apocalipse());
    }
    
    public void pause(){
        Greenfoot.setWorld(new Pause(this));
    }
    
    public void continuar(){
        Greenfoot.setWorld(this);
    }
    
    public void concluirFase(){
        this.faseConcluida=true;
    }
    
    private boolean faseConcluida;
    private boolean comeco;
    private boolean finaliza;
    
    private GreenfootImage img = new GreenfootImage("fase0.png");
    private Flora chefao = new Flora();
    private Oberon ob = new Oberon();
    private Elevador elevador = new Elevador();
    
    
}
