namespace The_App_That_Does_Nothing
{
    partial class AppDoesNothing
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnMain = new System.Windows.Forms.Button();
            this.chkbxMain = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // btnMain
            // 
            this.btnMain.Location = new System.Drawing.Point(44, 22);
            this.btnMain.Name = "btnMain";
            this.btnMain.Size = new System.Drawing.Size(75, 23);
            this.btnMain.TabIndex = 0;
            this.btnMain.Text = "btn";
            this.btnMain.UseVisualStyleBackColor = true;
            this.btnMain.Click += new System.EventHandler(this.button1_Click);
            // 
            // chkbxMain
            // 
            this.chkbxMain.AutoSize = true;
            this.chkbxMain.Location = new System.Drawing.Point(39, 51);
            this.chkbxMain.Name = "chkbxMain";
            this.chkbxMain.Size = new System.Drawing.Size(49, 17);
            this.chkbxMain.TabIndex = 1;
            this.chkbxMain.Text = "chbx";
            this.chkbxMain.UseVisualStyleBackColor = true;
            // 
            // AppDoesNothing
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.chkbxMain);
            this.Controls.Add(this.btnMain);
            this.Name = "AppDoesNothing";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnMain;
        private System.Windows.Forms.CheckBox chkbxMain;
    }
}

