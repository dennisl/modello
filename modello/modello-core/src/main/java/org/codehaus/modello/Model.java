package org.codehaus.modello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:jason@modello.org">Jason van Zyl</a>
 *
 * @version $Id$
 */
public class Model
    extends BaseElement
{
    private String id;

    private List classes = new ArrayList();

    private transient Map classMap = new HashMap();

    private String packageName;

    private String root;

    public Model()
    {
    }

    public String getId()
    {
        return id;
    }

    public List getClasses()
    {
        return classes;
    }

    public String getRoot()
    {
        return root;
    }

    public String getPackageName()
    {
        return packageName;
    }

    public ModelClass getClass( String type )
    {
        return (ModelClass) classMap.get( type );
    }

    public void addClass( ModelClass modelClass )
    {
        getClasses().add( modelClass );

        classMap.put( modelClass.getName(), modelClass );
    }

    public void initialize()
    {
        for ( Iterator i = classes.iterator(); i.hasNext(); )
        {
            ModelClass modelClass = (ModelClass) i.next();

            classMap.put( modelClass.getName(), modelClass );

            modelClass.initialize( this );
        }
    }

    public void validate()
    {
    }
}