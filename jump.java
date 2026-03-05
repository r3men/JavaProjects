/*
Name: Raymond Zhang
Program Name: Processing Jump Game
Date: 2/8/24
Extra: I made a high score, as well as a tree that gets wider over time (to make it harder for the player). 

*/

float pX = 50;
float pY = 400;
float pYSpeed = 0;

float eX = 1030;
float eY = 450;
float eXSpeed = -7.5;

float tX1 = 500;
float tW1 = 50;
float tX2 = 425;
float tW2 = 200;

float gravity = 0.5;
float jumpVel = -10;

int score = 0;
int highscore = 0;

boolean jump = false;
boolean gameover = false;

void setup() {
 size(1080, 720);
}
void draw() {
  background(136, 206, 235); // Sets the background to a light blue (sky color).
  drawGround();
  drawPlayer();
  drawEnemy();
  drawSun();
  if (score > 10) {
    drawTree();
    tX1 -= 0.1;
    tW1 += 0.1;
    tX2 -= 0.1;
    tW2 += 0.1;
  }
  updatePlayer();
  updateEnemy();
  drawScore();
  if (gameover) {
    fill(255, 0, 0);
    textSize(50);
    text("Game Over!", 800, 50);
    tX1 = 500;
    tW1 = 50;
    tX2 = 425;
    tW2 = 200;
  }
  if (eX == 930) {
    gameover = false; // Removes the "Game Over!" text after the enemy's position is back to 930.
  }
}
void drawGround() {
  fill(0, 255, 0);
  rect(0, 500, 1080, 270);
}

void drawPlayer() {
  fill(50, 100, 250);
  rect(pX, pY, 100, 100);
}
void drawSun() {
  fill(255, 255, 0);
  circle(0, 0, 200);
  fill(255, 255, 0);
}
// Extra:
void drawTree() {
  fill(165, 42, 42);
  rect(tX1, 300, tW1, 200);
  fill(0, 255, 0);
  rect(tX2, 200, tW2, 100);
}
void updatePlayer() {
  pYSpeed += gravity;
  pY += pYSpeed;
  if (pY > 400) {
    pY = 400;
    jump = false;
  }
}
void updateEnemy() {
  eX += eXSpeed;
  if ((eX < pX + 100) && (eX + 50 > pX) && (pY + 100 > 450)) {
    gameover = true; // Sets game to gameover if enemy collides with player.
    if (highscore < score) {
      highscore = score;
    }
    eX = 1030;
    score = 0;
    eXSpeed = -10;
  }
  if (eX < 0 && !gameover) {
    score++;
    eXSpeed -= 0.01;
  }
  if (eX < 0) {
    eX = 1030;
  }
}
void drawEnemy() {
  fill(255, 0, 0);
  rect(eX, eY, 50, 50);
}
void drawScore() {
  fill(255, 0, 0);
  textSize(50);
  text("Score: " + score ,550, 50);
  fill(255, 0, 0);
  textSize(50);
  text("High Score: " + highscore , 150, 50);
}
void keyPressed() {
  if (key == ' ' && !jump) {
    pYSpeed = jumpVel;
    jump = true;
  }
}



