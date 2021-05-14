//P2 RGBColor
//Submitted by Kyle Bush

public class RGBColor {
        private int red;
        private int green;
        private int blue;
        

        public RGBColor(int red, int green, int blue){
                this.red = red;
                this.green = green;
                this.blue = blue;
        }
        
        @Override
        public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        RGBColor color = (RGBColor) other;
        return red == color.red &&
                green == color.green &&
                blue == color.blue;
    }
        
        @Override
        public String toString(){
                return String.format("rgb(%d,%d,%d)",this.getRed(),this.getGreen(),this.getBlue());
        }
        
        public String toHex(){
                return String.format("#%02x%02x%02x", red, green, blue);
        }

        private int getRed() {
                return red;
        }

        private int getGreen() {
                return green;
        }

        private int getBlue() {
                return blue;
        }
}