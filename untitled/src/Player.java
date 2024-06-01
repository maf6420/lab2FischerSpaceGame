
    /**
     * The Player class contains 3 different parameters inside of it
     * Ammo is the amount of times a player can fire before needing to collect resupplies
     * Health is the amount of times a player can take damage before game over
     * Speed is governed by the Shiptype chosen by the player in the beginning
     */
    public class Player {
        public Player() {

        }

        public double getAmmo() {
            return Ammo;
        }

        public void setAmmo(int ammo) {
            Ammo = ammo;
        }

        public double getHealth() {
            return Health;
        }

        public void setHealth(int health) {
            Health = health;
        }

        public double getSpeed() {
            return Speed;
        }

        public void setSpeed(int speed) {
            Speed = speed;
        }
        public int Ammo;
        public int Health;
        public int Speed;

        public Player(int Ammo, int Health, int Speed) {
            this.Ammo = Ammo;
            this.Health = Health;
            this.Speed = Speed;
        }

        public String toString() {
            return "Stats{Ammo=" + this.Ammo + ", Health='" + this.Health + "Speed=" + this.Speed + "}";
        }
    }



