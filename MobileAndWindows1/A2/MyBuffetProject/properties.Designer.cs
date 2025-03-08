namespace MyBuffetProject
{
    partial class properties
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
            this.strangerText = new System.Windows.Forms.TextBox();
            this.quitButton = new System.Windows.Forms.Button();
            this.maxBtn = new System.Windows.Forms.Button();
            this.dustBtn = new System.Windows.Forms.Button();
            this.steveBtn = new System.Windows.Forms.Button();
            this.willBtn = new System.Windows.Forms.Button();
            this.mikeBtn = new System.Windows.Forms.Button();
            this.elevenBtn = new System.Windows.Forms.Button();
            this.BtnShowNames = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // strangerText
            // 
            this.strangerText.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.strangerText.Location = new System.Drawing.Point(153, 255);
            this.strangerText.Name = "strangerText";
            this.strangerText.Size = new System.Drawing.Size(156, 20);
            this.strangerText.TabIndex = 17;
            this.strangerText.Text = "Stranger Things";
            // 
            // quitButton
            // 
            this.quitButton.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.quitButton.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.quitButton.ForeColor = System.Drawing.Color.Red;
            this.quitButton.Location = new System.Drawing.Point(378, 12);
            this.quitButton.Name = "quitButton";
            this.quitButton.Size = new System.Drawing.Size(75, 23);
            this.quitButton.TabIndex = 16;
            this.quitButton.Text = "Quit";
            this.quitButton.UseVisualStyleBackColor = true;
            this.quitButton.Click += new System.EventHandler(this.quitButton_Click);
            // 
            // maxBtn
            // 
            this.maxBtn.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.maxBtn.Location = new System.Drawing.Point(234, 226);
            this.maxBtn.Name = "maxBtn";
            this.maxBtn.Size = new System.Drawing.Size(75, 23);
            this.maxBtn.TabIndex = 15;
            this.maxBtn.Text = "Max";
            this.maxBtn.UseVisualStyleBackColor = false;
            // 
            // dustBtn
            // 
            this.dustBtn.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.dustBtn.Location = new System.Drawing.Point(153, 197);
            this.dustBtn.Name = "dustBtn";
            this.dustBtn.Size = new System.Drawing.Size(75, 23);
            this.dustBtn.TabIndex = 14;
            this.dustBtn.Text = "Dustin";
            this.dustBtn.UseVisualStyleBackColor = false;
            // 
            // steveBtn
            // 
            this.steveBtn.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.steveBtn.Location = new System.Drawing.Point(153, 226);
            this.steveBtn.Name = "steveBtn";
            this.steveBtn.Size = new System.Drawing.Size(75, 23);
            this.steveBtn.TabIndex = 13;
            this.steveBtn.Text = "Steve";
            this.steveBtn.UseVisualStyleBackColor = false;
            // 
            // willBtn
            // 
            this.willBtn.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.willBtn.Location = new System.Drawing.Point(234, 168);
            this.willBtn.Name = "willBtn";
            this.willBtn.Size = new System.Drawing.Size(75, 23);
            this.willBtn.TabIndex = 12;
            this.willBtn.Text = "Will";
            this.willBtn.UseVisualStyleBackColor = false;
            // 
            // mikeBtn
            // 
            this.mikeBtn.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.mikeBtn.Location = new System.Drawing.Point(234, 197);
            this.mikeBtn.Name = "mikeBtn";
            this.mikeBtn.Size = new System.Drawing.Size(75, 23);
            this.mikeBtn.TabIndex = 11;
            this.mikeBtn.Text = "Mike";
            this.mikeBtn.UseVisualStyleBackColor = false;
            // 
            // elevenBtn
            // 
            this.elevenBtn.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.elevenBtn.Location = new System.Drawing.Point(153, 168);
            this.elevenBtn.Name = "elevenBtn";
            this.elevenBtn.Size = new System.Drawing.Size(75, 23);
            this.elevenBtn.TabIndex = 10;
            this.elevenBtn.Text = "Eleven";
            this.elevenBtn.UseVisualStyleBackColor = false;
            // 
            // BtnShowNames
            // 
            this.BtnShowNames.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.BtnShowNames.Location = new System.Drawing.Point(12, 12);
            this.BtnShowNames.Name = "BtnShowNames";
            this.BtnShowNames.Size = new System.Drawing.Size(150, 23);
            this.BtnShowNames.TabIndex = 9;
            this.BtnShowNames.Text = "Show Control Names";
            this.BtnShowNames.UseVisualStyleBackColor = false;
            this.BtnShowNames.Click += new System.EventHandler(this.BtnShowNames_Click);
            // 
            // properties
            // 
            this.AcceptButton = this.quitButton;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.LightGray;
            this.BackgroundImage = global::MyBuffetProject.Properties.Resources.back;
            this.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.CancelButton = this.quitButton;
            this.ClientSize = new System.Drawing.Size(465, 340);
            this.Controls.Add(this.strangerText);
            this.Controls.Add(this.quitButton);
            this.Controls.Add(this.maxBtn);
            this.Controls.Add(this.dustBtn);
            this.Controls.Add(this.steveBtn);
            this.Controls.Add(this.willBtn);
            this.Controls.Add(this.mikeBtn);
            this.Controls.Add(this.elevenBtn);
            this.Controls.Add(this.BtnShowNames);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "properties";
            this.Text = "Properties";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox strangerText;
        private System.Windows.Forms.Button quitButton;
        private System.Windows.Forms.Button maxBtn;
        private System.Windows.Forms.Button dustBtn;
        private System.Windows.Forms.Button steveBtn;
        private System.Windows.Forms.Button willBtn;
        private System.Windows.Forms.Button mikeBtn;
        private System.Windows.Forms.Button elevenBtn;
        private System.Windows.Forms.Button BtnShowNames;
    }
}