PImage bg;
PImage planeImg;
PImage bombImg;
float bgX = 0;
float bgSpeed = 5;

float planeX = -50;
float planeY = height/2;
float planeSpeed = 5;
float bombX;
float bombY;
float bombSpeed = 10;
boolean bombDropped = false;

void setup() {
  size(960, 600);
  bg = loadImage("bg.jpg");
  planeImg = loadImage("Fy.png");
  bombImg = loadImage("poop.png");
  bombX = planeX + planeImg.width * 0.7;
  bombY = planeY + planeImg.height * 0.3;
}

void draw() {
  // Draw the background
  image(bg, bgX, 0);
  image(bg, bgX + bg.width, 0);
  
  // Update the background position
  bgX -= bgSpeed;
  
  // If the background has scrolled all the way to the left, reset its position
  if (bgX <= -bg.width) {
    bgX = 0;
  }
  
  // Draw the plane image
  image(planeImg, planeX, planeY);
  
  // Update the plane's position
  planeX += planeSpeed;
  
  // If the plane goes off the right edge of the screen, reset its position
  if (planeX > width + 50) {
    planeX = -50;
  }
  
  // Drop the bomb when the user presses Enter
  if (keyPressed && key == ENTER && !bombDropped) {
    bombDropped = true;
  }
  
  // Draw the bomb if it has been dropped
  if (bombDropped) {
    image(bombImg, bombX, bombY);
    bombY += bombSpeed;
    
    // Check if the bomb has hit the ground
    if (bombY > height) {
      bombDropped = false;
      bombX = planeX + planeImg.width * 0.7;
      bombY = planeY + planeImg.height * 0.3;
    }
  }
}
