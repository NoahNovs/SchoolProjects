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

    //Author: Noah Novales
    //Date Created: 10/24/22
    //Last Modified By: Noah Novales
    //Date Last Modified: 11/15/22
    //Assignment: HW Project 2


    //DESIGN CHANGES
    //made all buttons exect quitButton back blueish background
    //made text (stranger things) to italic
    //made quit button bold and red
    public partial class properties : Form
    {
        public properties()
        {
            InitializeComponent();
        }

        //uses a message box showing the control # for all buttons and text boxes in the form
        private void BtnShowNames_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < Controls.Count; i++)
            {
                MessageBox.Show("Control #" + i.ToString() +
                    " has the name " + Controls[i].Name);
            }
        }

        private void quitButton_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
