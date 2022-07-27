import javax.swing.undo.CannotUndoException;
import javax.swing.undo.CannotRedoException;
public class Function_Edit
{
  GUI gui;
  public Function_Edit(GUI gui)
  {
    this.gui=gui;
  }
  public void undo()
  {
    try
    {
      gui.um.undo();
    }
    catch(CannotUndoException ex)
    {
      System.out.println(ex);
    }
  }
  public void redo() 
  {
    try
    {
      gui.um.redo();
    }
    catch(CannotRedoException ey)
    {
      System.out.println(ey);
    }
  }
}