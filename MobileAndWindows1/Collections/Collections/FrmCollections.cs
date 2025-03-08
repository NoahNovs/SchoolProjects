using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Collections
{
    public partial class FrmCollections : Form
    {
        public FrmCollections()
        {
            InitializeComponent();
        }

        //show all of the names with Message Box
        private void BtnShowNames_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < Controls.Count; i++)
            {
                MessageBox.Show("Control #" + i.ToString() + 
                    " has the name " + Controls[i].Name);
            }
        }

        //quits the app at the bottom of the page
        private void quitButton_Click(object sender, EventArgs e)
        {
            Close();
        }
    }
}
