using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyBuffetProject
{
    public partial class MyBuffetName : Form
    {
        public MyBuffetName()
        {
            InitializeComponent();
        }

        const bool DefPromptOnExit = true;
        bool BlnPromptOnExit = DefPromptOnExit;

        //Event handlers

        private void SelectPictureButton_Click(object sender, EventArgs e)
        {
            //translates to if the dialog is true, then execute the code
            if(ofdSelectPic.ShowDialog() == DialogResult.OK)
            {
                //load pic
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
            ObjDrawBorder.DrawRectangle(Pens.Blue,
                PicBox.Left - 1, PicBox.Top - 1,
                width: PicBox.Width + 1, height: PicBox.Height + 1);

            //get rid of the "pen" since it is no longer used
            ObjDrawBorder.Dispose();
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

            ChkPromptExit.Checked = BlnPromptOnExit;
        }

        //when options button is clicked, then open the new form
        private void BtnOptions_Click(object sender, EventArgs e)
        {
            FrmBuffetOptions FrmBuffetOptionsDialog = new FrmBuffetOptions();
            FrmBuffetOptionsDialog.Show();
        }

        private void ChkPromptExit_CheckedChanged(object sender, EventArgs e)
        {
            BlnPromptOnExit = ChkPromptExit.Checked;
        }

        private void MyBuffetName_FormClosing(object sender, FormClosingEventArgs e)
        {
            if(BlnPromptOnExit)
            {
                if(MessageBox.Show("Close the Buffet Program?",
                    "Confirm Exit",
                    MessageBoxButtons.YesNo,
                    icon: MessageBoxIcon.Question)==DialogResult.No)
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
        }
    }
}
