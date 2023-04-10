// A3Q5, Game : Poop Catcher by Fyrooz Sakib Khan.

final int numTrees = 7;
final int scoreToWin = 70;
int score = 0;


class Bird {
  float x;
  float y;
  float speed;
  float size;
  boolean pooping;

  Bird(float x, float y, float speed, float size) {
    this.x = x;
    this.y = y;
    this.speed = speed;
    this.size = size;
    pooping = false;
  }

  void update() {
    x += speed;
    if (x > width + size) {
      x = -size;
    }
  }

  void display() {
    drawBird( x, y, size) ;

    if (pooping) {
      fill(139, 69, 19);
      ellipse(x, y+size/2, size/3, size/6);
      pooping = false;
    }
  }


  void drawBird(float x, float y, float size) {
    push();
    noStroke();
    fill(139, 69, 19);
    ellipse(x, y, size*2, size*1.5);

    // Head
    fill(255, 200, 150);
    ellipse(x + size*1.2, y - size*0.4, size*0.8, size*0.8);

    // Beak
    fill(255, 255, 0);
    triangle(x + size*1.4, y - size*0.2, x + size*1.6, y, x + size*1.4, y + size*0.2);

    // Eye
    fill(0);
    ellipse(x + size*1.2, y - size*0.6, size*0.4, size*0.4);

    // Wing
    fill(139, 69, 50);
    triangle(x, y, x + size*0.8, y - size*0.4, x, y - size);

    // Tail
    fill(139, 69, 70);
    triangle(x - size*1, y - size*0.2, x - size*1.8, y, x - size*1, y + size*0.2);
    pop();
  }


  void poop() {
    pooping = true;
  }
}


class Poop {
  float x;
  float y;
  float size;
  float speed;
  float velocity;
  float gravity = 0.4;

  Poop(float x, float y, float size, float speed) {
    this.x = x;
    this.y = y;
    this.size = 2 * size;
    this.speed = speed;
    this.velocity = 0;
  }

  void update() {
    velocity += gravity;
    y += velocity;
    x += speed * 1.0001; // for some 'unnatural feel. remove the const for natural motion.'

    // If poop hits the ground, it stays there.
    if (y > height - size/2) {
      y = height - size/2;
      velocity = 0;
      speed = 0;
    }
  }

  void display() {
    fill(102, 51, 0);
    ellipse(x, y, size, size/2);
  }
}



class Basket {
  float x;
  float y = 500;
  float width;
  float height;

  Basket(float x, float y, float width, float height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  void display() {
    fill(255);
    drawBasket(x, y, width, height);
  }

  void drawBasket(float x, float y, float width, float height) {
    
    // Body
    fill(0);
    rect(x - width/2, y - height/2, width, height);
    
    // Lid
    fill(100);
    rect(x - width/2, y - height/2 - height*0.2, width, height*0.2);
    
    // Handle
    fill(200);
    rect(x - width*0.3, y - height/2 - height*0.2, width*0.1, height*0.4);
    rect(x + width*0.2, y - height/2 - height*0.2, width*0.1, height*0.4);
  }

  void move() {
    x = mouseX - width/2;
    y = 499;
  }
}


Bird bird;
Basket basket;
Poop[] poops = new Poop[300];
int numPoops = 0;
float timeElapsed = 0;
float startTime;


float[] treeX = new float[numTrees];
float[] treeWidth = new float[numTrees];
float[] treeHeight = new float[numTrees];




void setup() {
  
  size(960, 600);
  textAlign(CENTER);
  textSize(20);

  // randomly generate tree positions and sizes
  for (int i = 0; i < numTrees; i++) {
    treeX[i] = random(width);
    treeWidth[i] = random(0.03*width, 0.07*width);
    treeHeight[i] = random(0.1*height, 0.2*height);
  }

  bird = new Bird(0, 0.15*height, 5, 50);
  basket = new Basket(width/2, height-50, 100, 50);
  startTime = millis();
}



void draw() {

  translate(-3, 0);
  drawBackground();

  // Display score and time
  fill(0);
  text("Score: " + score, width/2, 30);
  text("Time: " + (int)timeElapsed, width/2, 60);

  // draw the trees
  for (int i = 0; i < numTrees; i++) {
    drawTree(treeX[i], 0.8*height, treeWidth[i], treeHeight[i]);
  }

  // move the trees to the left
  for (int i = 0; i < numTrees; i++) {
    treeX[i] -= 3;

    // if the tree is off-screen, move it to the right with a new random size and height
    if (treeX[i] < -treeWidth[i]) {
      treeX[i] = width + random(0, width/2);
      treeWidth[i] = random(0.03*width, 0.07*width);
      treeHeight[i] = random(0.1*height, 0.2*height);
    }
  }

  bird.update();
  bird.display();
  basket.display();
  basket.move();

  // update and draw the poops
  for (int i = 0; i < numPoops; i++) {
    
    if (poops[i] != null) {
      
      poops[i].update();
      poops[i].display();

      if (poops[i].y > height) {
        score -= 5;
        poops[i] = null;
      }

      if (score < scoreToWin) {
        
        if (poops[i].y >= height - poops[i].size/2) {
          
          if (dist(mouseX, mouseY, poops[i].x, poops[i].y) < poops[i].size/2) {
            fill(0);
            textAlign(CENTER);
            textSize(30);
            text("Caught the poop!", width/2, height/2);
          } else {
            fill(0);
            textAlign(CENTER);
            textSize(30);
            text("Missed poop :(", width/2, height/2);
          }
        } else if (poops[i].y > 0) {
          fill(0);
          textAlign(CENTER);
          textSize(20);
          text("Catch the poop!", width/2, height/2);
        }
      }
    }
  }


  if (score >= scoreToWin) {
    // Game won
    fill(0);
    textAlign(CENTER);
    textSize(50);
    text("You won in " + (int)timeElapsed + " seconds!", width/2, height/2);
    return;
  }


  // If poop is caught, making the baskt smaller.
  for (int i = 0; i < numPoops; i++) {
    if (poops[i] != null &&
      poops[i].x + poops[i].size/2 > basket.x &&
      poops[i].x - poops[i].size/2 < basket.x + basket.width &&
      poops[i].y + poops[i].size/4 > basket.y &&
      poops[i].y - poops[i].size/4 < basket.y + basket.height) {

      poops[i] = null;
      score += 10;
      basket.width *= 0.95;
      basket.height *= 0.90;
    }
  }
  
  timeElapsed = (millis() - startTime) / 1000.0;
  

}


void drawBackground() {
  
  background(135, 206, 250);
  noStroke();
  fill(124, 252, 0);
  rect(0, 0.8*height, width, 0.2*height);
  fill(255, 165, 0);
  rect(0, 0.8*height, width, 0.02*height);
  
}


void drawTree(float x, float y, float trunkWidth, float trunkHeight) {

  // The trunk
  noStroke();
  fill(139, 69, 19);
  rect(x-trunkWidth/2, y-trunkHeight, trunkWidth, trunkHeight);

  // The leaves
  fill(34, 139, 34);
  ellipse(x-trunkWidth/2, y-trunkHeight*1.2, trunkWidth*1.5, trunkHeight*1.5);
  ellipse(x+trunkWidth/2, y-trunkHeight*1.2, trunkWidth*1.5, trunkHeight*1.5);
  ellipse(x, y-trunkHeight*1.8, trunkWidth*2, trunkHeight*2);
  
}


void keyPressed() {
  if (keyCode == ENTER || keyCode == RETURN || key == ' ') {
    if (numPoops < poops.length) {
      
      poops[numPoops] = new Poop(bird.x, bird.y, random(10, 20), random(5, 10));
      numPoops++;
      
    }
  }
}
