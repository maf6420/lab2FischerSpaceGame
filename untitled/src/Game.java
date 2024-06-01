class Game extends Player{
    public void setShip(String ship) {
        Ship = ship;
    }

    //Ship information
    private String Ship;

    public void setInvaders(int invaders) {
        Invaders = invaders;
    }

    public void setShiptype(String shiptype) {
        Shiptype = shiptype;
    }

    //Type of ship
    private String Shiptype;
    //Number of Invaders
    private int Invaders;

    public void setObstacles(int obstacles) {
        Obstacles = obstacles;
    }

    //Number of obstacles randomly scattered around the map
    private int Obstacles;

    public void setPowerups(int powerups) {
        Powerups = powerups;
    }

    //Number of randomly chosen powerups scattered around the map
    private double Powerups;

    /**
     *
     * Ship dictates information of the ship itself
     * Shiptype governs the type of ship, which determines the stats
     * Invaders governs the amount of invaders scattered across the map
     * Obstacles governs the amount of debris scattered across the map
     * Powerups governs the amount of powerups scattered across the map
     * Color is the color of the ship depending on the Shiptype
     */

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String Color;

    public Game(Shiptype Shiptype, int Invaders, int Obstacles, int Powerups, int Health, int Ammo, int Speed, String color){
        //Added this to make SQL commands run, clean up later
        super();
        this.Shiptype= String.valueOf(Shiptype);
        this.Invaders=Invaders;
        this.Obstacles=Obstacles;
        this.Powerups=Powerups;
        this.Health=Health;
        this.Ammo=Ammo;
        this.Speed=Speed;
        this.Color=color;
    }
    public String getShiptype() {return Shiptype;}
    public int getInvaders() {return Invaders;}
    public int getObstacles() {return Obstacles;}
    public int getPowerups() {return (int) Powerups;}



    public void start() {System.out.println("Game start!");}
    public void stop () {System.out.println("Game stop!");}
}
