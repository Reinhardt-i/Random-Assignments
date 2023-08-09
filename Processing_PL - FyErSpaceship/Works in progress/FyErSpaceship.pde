
// If you change DISPLAY_WIDTH and DISPLAY_HEIGHT, you also have to change the arguments of the size() in setup();
final int DISPLAY_WIDTH = 1000;
final int DISPLAY_HEIGHT = 625;

// Was having some problems doing the trigs for the quad spaceship, so I drew a triangle insted.
final float SHIP_SIZE = 30, SHIP_SHAPE = (PI/10);
final float SHIP_SPEED = 5, SHIP_ANGULAR_ACCELERATION = 0.1;

void setup() {
  size(1000, 625);
  background(40, 40, 43);
}

int dimention = 1;
float changedShipDir, currentShipDir = 0;
float shipForwardVerticeX = SHIP_SIZE, shipForwardVerticeY = DISPLAY_HEIGHT / 2;
float rightVerticeX, rightVerticeY, leftVerticeX, leftVerticeY;
void drawShip()
{
  rightVerticeX = shipForwardVerticeX - (SHIP_SIZE * cos(currentShipDir - SHIP_SHAPE));
  rightVerticeY = shipForwardVerticeY - (SHIP_SIZE * sin(currentShipDir - SHIP_SHAPE));
  leftVerticeX = shipForwardVerticeX -(SHIP_SIZE * cos(currentShipDir + SHIP_SHAPE));
  leftVerticeY = shipForwardVerticeY - (SHIP_SIZE * sin(currentShipDir + SHIP_SHAPE));

  stroke(0);
  strokeWeight(1);
  fill(200, 10, 10);
  triangle(shipForwardVerticeX, shipForwardVerticeY, leftVerticeX, leftVerticeY, rightVerticeX, rightVerticeY );
  strokeWeight(3);
  point((shipForwardVerticeX + rightVerticeX + leftVerticeX) / 3, (shipForwardVerticeY + rightVerticeY + leftVerticeY) / 3); // point on the spaceship
}


boolean isShipMoving = false, isShipReset;
void keyPressed()
{
  changedShipDir = 2 * PI;
  if (!isShipMoving && key == ' ')
  {
    isShipMoving = true;
    isShipReset = false;
  } else if (isShipMoving && key ==' ')
  {
    isShipReset = true;
    isShipMoving = false;
  }
}

float shipVelocityX, shipVelocityY;
void moveShip()
{
  shipVelocityX = SHIP_SPEED * cos(currentShipDir);
  shipVelocityY = SHIP_SPEED * sin(currentShipDir);

  if (isShipMoving)
  {
    shipForwardVerticeX += shipVelocityX;
    shipForwardVerticeY += shipVelocityY;
  }

  if ((shipForwardVerticeX >= DISPLAY_WIDTH || shipForwardVerticeX <= 0) || (shipForwardVerticeY >= DISPLAY_HEIGHT || shipForwardVerticeY <= 0))
  {
    isShipReset = true;
    isShipMoving = false;
  }

  if (keyPressed)
  {
    if (key == 'd'|| key =='l')
    {
      currentShipDir += SHIP_ANGULAR_ACCELERATION;
    } else if (key == 'a'|| key =='j')
    {
      currentShipDir -= SHIP_ANGULAR_ACCELERATION;
    }
  }
}



void resetShip()
{
  if (isShipReset)
  {
    shipForwardVerticeX = SHIP_SIZE;
    shipForwardVerticeY = DISPLAY_HEIGHT / 2;
    currentShipDir = changedShipDir;
    isShipReset = false;
    isShipMoving = false;

    resetGate(); //resets the postion of the target line
  }
}


//Variable for the location and length of the target line
float gateLength = 150;
float gateStartX = 1000, gateStartY = random(200, DISPLAY_HEIGHT - 200);
float gateEndX = (1000 - gateLength), gateEndY = gateStartY;
boolean dimPassed = true;
void resetGate()
{
  if (dimPassed)
  {

    gateStartX = 1000;
    gateStartY = random(200, DISPLAY_HEIGHT - 200);
  }
  dimention ++;
}

void drawGate(float x, float y, int dir)
{
  stroke(0, 255, 0);
  strokeWeight(15);
  if (dir == -1) {
    gateStartX = x;
    gateStartY = y;
    gateEndX = x - gateLength;
    gateEndY = gateStartY;
    line(gateStartX, gateStartY, gateEndX, gateEndY);
    line(gateStartX, gateStartY - 100, gateEndX, gateEndY - 100);
  }
}


void checkCollision()
{
  //boolean hitTarget = ((gateStartY <= shipForwardVerticeY) && (shipForwardVerticeY <= gateEndY) && (shipForwardVerticeX >+ DISPLAY_WIDTH-10));

  float sx = (shipForwardVerticeX + rightVerticeX + leftVerticeX) / 3, sy = (shipForwardVerticeY + rightVerticeY + leftVerticeY) / 3;
  boolean ifHit = ( sx >= 1000 ) && ( sy > gateStartY - 5 ) && ( sy < ( gateStartY + 105 ) );

  if (ifHit)
  {
    dimention ++;
    isShipReset = true;
  }
}


void drawLevel()
{
  textSize(20);
  textAlign(CENTER, BOTTOM);
  textAlign(300, 250);
  fill(255);
  text("Current Dimention : " + dimention, 30, textAscent() + 10);
}


void draw()
{
  background(40, 40, 43);
  resetShip();
  drawShip();
  moveShip();
  drawGate(1000, gateStartY, -1);
  checkCollision();
  drawLevel();
}
