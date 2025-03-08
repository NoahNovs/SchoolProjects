using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

//Author: Noah Novales
//Date Created: 10/24/22
//Last Modified By: Noah Novales
//Date Last Modified: 11/15/22
//Assignment: HW Project 2


//PROPERTIES CHANGED


//make sizeMode stretch on picBox
//flatStyle to popup in buttons other than quit
    //system felt right with "quit" since it is a system action
//make text color of "quit" to red (for a warning)
//cursor over "quit" has hand to make it different than the other buttons
//make text color of "draw border" to the color it will outline (orange)
//make x and y positions italic (looks better)
//make shrink/enlarge buttons into icons, set background layout image to stretch
    //this is to make the image take up the whole button
//make x and y textSize from 8.25 to 10 to make it pop out when shown
//"backColor" changed to info to make icons pop more

namespace MyBuffetProject
{
    public partial class MyBuffetName : Form
    {
        //only when the border is drawn is when this can go to true
        //to make sure border is not drawn prematurely when button is not clicked first
        bool hasBorder = false;

        public MyBuffetName()
        {
            InitializeComponent();
        }

        const bool DefPromptOnExit = false;
        bool BlnPromptOnExit = DefPromptOnExit;

        //Event handlers

        private void SelectPictureButton_Click(object sender, EventArgs e)
        {
            //translates to if the dialog is true, then execute the code
            if(ofdSelectPic.ShowDialog() == DialogResult.OK)
            {
                //load pic
                //accepts windows bitmaps, JPEG, PNG, and GIF
                PicBox.Image = Image.FromFile(ofdSelectPic.FileName);

                //adds to text for whole form
                Text = String.Concat("A290 Buffet(" + ofdSelectPic.FileName + ")");
            }
        }

        private void quitButton_Click(object sender, EventArgs e)
        {
            //exiting the app using quit button
            Close();
        }

        private void growButton_Click(object sender, EventArgs e)
        {
            //add 20 pixels to width and height
            Width += 20;
            Height += 20;
        }

        private void shrinkButton_Click(object sender, EventArgs e)
        {
            //decrease by 20 pixels to width and height
            Width -= 20;
            Height -= 20;
        }

        private void DrawBoarderButton_Click(object sender, EventArgs e)
        {
            //initialize variable to null
            Graphics ObjDrawBorder;

            //make the graphics
            ObjDrawBorder = CreateGraphics();

            //clear what was there before
            ObjDrawBorder.Clear(SystemColors.Control);

            //make a rectangle from the PicBox
            //make border orange color
            ObjDrawBorder.DrawRectangle(Pens.Orange,
                PicBox.Left - 1, PicBox.Top - 1,
                width: PicBox.Width + 1, height: PicBox.Height + 1);

            //get rid of the "pen" since it is no longer used
            ObjDrawBorder.Dispose();

            hasBorder = true;
        }

        

        //ignore for now, accidentally clicked on it
        private void labelX_Click(object sender, EventArgs e)
        {

        }

        //get the x and y position and set it equal to the x and y label
        private void PicBox_MouseMove(object sender, MouseEventArgs e)
        {
            labelX.Text = "X: " + e.X.ToString();
            labelY.Text = "Y: " + e.Y.ToString();
        }

        //when you go off of the picture box, then you do not need the
        //position
        //label should be set to an empty string
        private void PicBox_MouseLeave(object sender, EventArgs e)
        {
            labelX.Text = "";
            labelY.Text = "";
        }

        //make the labels appear when over picture box for first time
        private void MyBuffetName_Load(object sender, EventArgs e)
        {
            labelX.Text = "";
            labelY.Text = "";
            //makes sure that the checkbox is unchecked at the start
            exitBox.Checked = BlnPromptOnExit;
        }

        //call this when resizing
        private void MyBuffetName_Resize(object sender, EventArgs e)
        {
            //do what is in DrawBoarderButton if the region already has a border
            if (hasBorder)
            {
                DrawBoarderButton_Click(sender, e);
            }
        }

        //call when the region is changed
        private void MyBuffetName_RegionChanged(object sender, EventArgs e)
        {
            //do what is in DrawBoarderButton if the region already has a border
            if (hasBorder)
            {
                DrawBoarderButton_Click(sender, e);
            }
        }

        private void MyBuffetName_Leave(object sender, EventArgs e)
        {
            //do what is in DrawBoarderButton if the region already has a border
            if (hasBorder)
            {
                DrawBoarderButton_Click(sender, e);
            }
        }

        //call when location of app is changed to make sure border stays
        private void MyBuffetName_LocationChanged(object sender, EventArgs e)
        {
            //do what is in DrawBoarderButton if the region already has a border
            if (hasBorder)
            {
                DrawBoarderButton_Click(sender, e);
            }
        }

        private void MyBuffetName_FormClosing(object sender, FormClosingEventArgs e)
        {
            if (BlnPromptOnExit)
            {
                if (MessageBox.Show("Close the Buffet Program?",
                    "Confirm Exit",
                    MessageBoxButtons.YesNo,
                    icon: MessageBoxIcon.Question) == DialogResult.No)
                //display a dialog with Yes/No buttons that asks "Close
                //the Buffet Program?,
                //uses the "?" icon, and has the caption "Confirm Exit"
                //If the user selects "No", then
                {

                    //Cancel the event frmBuffet_FormClosing
                    e.Cancel = true;
                }
                //otherwise, close the application
            }
            //add a cancel if the checkbox is not checked
            else
            {
                e.Cancel = true;
            }
        }
        //updates the boolean to correspond with the checkbox
        private void exitBox_CheckedChanged(object sender, EventArgs e)
        {
            BlnPromptOnExit = exitBox.Checked;
        }

        //creates the new form and opens it
        private void optionsButton_Click(object sender, EventArgs e)
        {
            FrmOptions frmOptions = new FrmOptions();
            frmOptions.Show();
        }

        //creates the collection/properties form and opens it
        private void collectionButton_Click(object sender, EventArgs e)
        {
            properties prop = new properties();
            prop.Show();
        }
    }
}
