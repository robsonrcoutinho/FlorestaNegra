import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta classe é referentee ao menu inicial
 * sua ações são relativas a funcionalidas de
 * seus botões.
 * since Novembro, 2013.
 */
public class Menu extends World
{

    /**
     * No construtor é adicionado  objetos
     * referentes aos botões. Também é redimenionado a
     * imagem para 600*400 e adicionado ao mundo.
     */
    public Menu()
    { 
       super(600, 400,1);
        img.scale(600, 400);
        setBackground(img);
        addObject(new Jogar(), 300, 240);
        addObject(new Opcoes(),300, 275);
        addObject(new Historia(),300, 311);
        hp.recuperarVidas();
        en.recuperarTodaEnergia();
        
    }
    
    public void started(){
        somFundo.play();
    }
    
    public void stoped(){
        desligarSom();
    }
    
    public void desligarSom(){
        somFundo.stop();
    }
       private  GreenfootImage img = new GreenfootImage("Menu.jpg");
       private  GreenfootSound somFundo = new GreenfootSound("florestaNegraMenu.mp3");
       private  QuantidadeVidas hp = new QuantidadeVidas();
       private  Energia en = new Energia();
    }
    
    
