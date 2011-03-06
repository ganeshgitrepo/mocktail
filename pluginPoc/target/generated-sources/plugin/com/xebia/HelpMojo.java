package com.xebia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Display help information on smok.<br/> Call <pre>  mvn smok:help -Ddetail=true -Dgoal=&lt;goal-name&gt;</pre> to display parameter details.
 *
 * @version generated on Tue Mar 01 23:49:31 IST 2011
 * @author org.apache.maven.tools.plugin.generator.PluginHelpGenerator (version 2.5.1)
 * @goal help
 * @requiresProject false
 */
public class HelpMojo
    extends AbstractMojo
{
    /**
     * If <code>true</code>, display all settable properties for each goal.
     * 
     * @parameter expression="${detail}" default-value="false"
     */
    private boolean detail;

    /**
     * The name of the goal for which to show help. If unspecified, all goals will be displayed.
     * 
     * @parameter expression="${goal}"
     */
    private java.lang.String goal;

    /**
     * The maximum length of a display line, should be positive.
     * 
     * @parameter expression="${lineLength}" default-value="80"
     */
    private int lineLength;

    /**
     * The number of spaces per indentation level, should be positive.
     * 
     * @parameter expression="${indentSize}" default-value="2"
     */
    private int indentSize;


    /** {@inheritDoc} */
    public void execute()
        throws MojoExecutionException
    {
        if ( lineLength <= 0 )
        {
            getLog().warn( "The parameter 'lineLength' should be positive, using '80' as default." );
            lineLength = 80;
        }
        if ( indentSize <= 0 )
        {
            getLog().warn( "The parameter 'indentSize' should be positive, using '2' as default." );
            indentSize = 2;
        }

        StringBuffer sb = new StringBuffer();

        append( sb, "com.xebia:smok:1.0-SNAPSHOT", 0 );
        append( sb, "", 0 );

        append( sb, "smok Maven Plugin", 0 );
        append( sb, "(no description available)", 1 );
        append( sb, "", 0 );

        if ( goal == null || goal.length() <= 0 )
        {
            append( sb, "This plugin has 2 goals:", 0 );
            append( sb, "", 0 );
        }

        if ( goal == null || goal.length() <= 0 || "help".equals( goal ) )
        {
            append( sb, "smok:help", 0 );
            append( sb, "Display help information on smok.\nCall\n\u00a0\u00a0mvn\u00a0smok:help\u00a0-Ddetail=true\u00a0-Dgoal=<goal-name>\nto display parameter details.", 1 );
            append( sb, "", 0 );
            if ( detail )
            {
                append( sb, "Available parameters:", 1 );
                append( sb, "", 0 );

                append( sb, "detail (Default: false)", 2 );
                append( sb, "If true, display all settable properties for each goal.", 3 );
                append( sb, "", 0 );

                append( sb, "goal", 2 );
                append( sb, "The name of the goal for which to show help. If unspecified, all goals will be displayed.", 3 );
                append( sb, "", 0 );

                append( sb, "indentSize (Default: 2)", 2 );
                append( sb, "The number of spaces per indentation level, should be positive.", 3 );
                append( sb, "", 0 );

                append( sb, "lineLength (Default: 80)", 2 );
                append( sb, "The maximum length of a display line, should be positive.", 3 );
                append( sb, "", 0 );
            }
        }

        if ( goal == null || goal.length() <= 0 || "smok".equals( goal ) )
        {
            append( sb, "smok:smok", 0 );
            append( sb, "Goal which touches a timestamp file.", 1 );
            append( sb, "", 0 );
            if ( detail )
            {
                append( sb, "Available parameters:", 1 );
                append( sb, "", 0 );

                append( sb, "ajdtBuildDefFile", 2 );
                append( sb, "Where to find the ajdt build definition file. If set this will override the use of project sourcedirs.", 3 );
                append( sb, "", 0 );

                append( sb, "argumentFileName (Default: builddef.lst)", 2 );
                append( sb, "The filename to store build configuration in. This file will be placed in the project build output directory, and will contain all the arguments passed to the compiler in the last run, and also all the filenames included in the build. Aspects as well as java files.", 3 );
                append( sb, "", 0 );

                append( sb, "aspectDirectory (Default: src/main/aspect)", 2 );
                append( sb, "The source directory for the aspects", 3 );
                append( sb, "", 0 );

                append( sb, "bootclasspath", 2 );
                append( sb, "Override location of VM\'s bootclasspath for purposes of evaluating types when compiling. Path is a single argument containing a list of paths to zip files or directories, delimited by the platform-specific path delimiter.", 3 );
                append( sb, "", 0 );

                append( sb, "complianceLevel", 2 );
                append( sb, "Specify compiler compliance setting (1.3 to 1.6) default is 1.4", 3 );
                append( sb, "", 0 );

                append( sb, "deprecation", 2 );
                append( sb, "Toggle warningmessages on deprecations", 3 );
                append( sb, "", 0 );

                append( sb, "emacssym", 2 );
                append( sb, "Generate .ajesym symbol files for emacs support", 3 );
                append( sb, "", 0 );

                append( sb, "encoding", 2 );
                append( sb, "Specify default source encoding format.", 3 );
                append( sb, "", 0 );

                append( sb, "excludes", 2 );
                append( sb, "List of ant-style patterns used to specify the aspects that should be excluded when compiling. When none specified all .java and .aj files in the project source directories, or directories spesified by the ajdtDefFile property are included.", 3 );
                append( sb, "", 0 );

                append( sb, "forceAjcCompile", 2 );
                append( sb, "Forces re-compilation, regardless of whether the compiler arguments or the sources have changed.", 3 );
                append( sb, "", 0 );

                append( sb, "includes", 2 );
                append( sb, "List of ant-style patterns used to specify the aspects that should be included when compiling. When none specified all .java and .aj files in the project source directories, or directories spesified by the ajdtDefFile property are included.", 3 );
                append( sb, "", 0 );

                append( sb, "noImportError", 2 );
                append( sb, "Emit no errors for unresolved imports;", 3 );
                append( sb, "", 0 );

                append( sb, "outxml", 2 );
                append( sb, "Generate aop.xml file for load-time weaving with default name.(/META-INF/aop.xml)", 3 );
                append( sb, "", 0 );

                append( sb, "outxmlfile", 2 );
                append( sb, "Generate aop.xml file for load-time weaving with custom name.", 3 );
                append( sb, "", 0 );

                append( sb, "preserveAllLocals", 2 );
                append( sb, "Preserve all local variables during code generation (to facilitate debugging).", 3 );
                append( sb, "", 0 );

                append( sb, "proceedOnError", 2 );
                append( sb, "Keep compiling after error, dumping class files with problem methods", 3 );
                append( sb, "", 0 );

                append( sb, "recordingDirectory", 2 );
                append( sb, "(no description available)", 3 );
                append( sb, "", 0 );

                append( sb, "referenceInfo", 2 );
                append( sb, "Compute reference information.", 3 );
                append( sb, "", 0 );

                append( sb, "repeat", 2 );
                append( sb, "Repeat compilation process N times (typically to do performance analysis).", 3 );
                append( sb, "", 0 );

                append( sb, "showWeaveInfo", 2 );
                append( sb, "Emit messages about weaving", 3 );
                append( sb, "", 0 );

                append( sb, "source (Default: ${project.build.java.target})", 2 );
                append( sb, "Toggle assertions (1.3, 1.4, or 1.6 - default is 1.4). When using -source 1.3, an assert() statement valid under Java 1.4 will result in a compiler error. When using -source 1.4, treat assert as a keyword and implement assertions according to the 1.4 language spec. When using -source 1.5 or higher, Java 5 language features are permitted.", 3 );
                append( sb, "", 0 );

                append( sb, "target (Default: ${project.build.java.target})", 2 );
                append( sb, "Specify classfile target setting (1.1 to 1.6) default is 1.2", 3 );
                append( sb, "", 0 );

                append( sb, "testAspectDirectory (Default: src/test/aspect)", 2 );
                append( sb, "The source directory for the test aspects", 3 );
                append( sb, "", 0 );

                append( sb, "verbose", 2 );
                append( sb, "Emit messages about accessed/processed compilation units", 3 );
                append( sb, "", 0 );

                append( sb, "warn", 2 );
                append( sb, "Emit warnings for any instances of the comma-delimited list of questionable code (eg \'unusedLocals,deprecation\'): see http://www.eclipse.org/aspectj/doc/released/devguide/ajc-ref.html#ajc for available settings", 3 );
                append( sb, "", 0 );

                append( sb, "XaddSerialVersionUID", 2 );
                append( sb, "Causes the compiler to calculate and add the SerialVersionUID field to any type implementing Serializable that is affected by an aspect. The field is calculated based on the class before weaving has taken place.", 3 );
                append( sb, "", 0 );

                append( sb, "XhasMember", 2 );
                append( sb, "Enables the compiler to support hasmethod(method_pattern) and hasfield(field_pattern) type patterns, but only within declare statements. It\'s experimental and undocumented because it may change, and because it doesn\'t yet take into account ITDs.", 3 );
                append( sb, "", 0 );

                append( sb, "Xlint", 2 );
                append( sb, "Set default level for messages about potential programming mistakes in crosscutting code. {level} may be ignore, warning, or error. This overrides entries in org/aspectj/weaver/XlintDefault.properties from aspectjtools.jar.", 3 );
                append( sb, "", 0 );

                append( sb, "XnoInline", 2 );
                append( sb, "(Experimental) do not inline around advice", 3 );
                append( sb, "", 0 );

                append( sb, "Xreweavable", 2 );
                append( sb, "(Experimental) runs weaver in reweavable mode which causes it to create woven classes that can be rewoven, subject to the restriction that on attempting a reweave all the types that advised the woven type must be accessible.", 3 );
                append( sb, "", 0 );

                append( sb, "XserializableAspects", 2 );
                append( sb, "(Experimental) Normally it is an error to declare aspects Serializable. This option removes that restriction.", 3 );
                append( sb, "", 0 );
            }
        }

        if ( getLog().isInfoEnabled() )
        {
            getLog().info( sb.toString() );
        }
    }

    /**
     * <p>Repeat a String <code>n</code> times to form a new string.</p>
     *
     * @param str String to repeat
     * @param repeat number of times to repeat str
     * @return String with repeated String
     * @throws NegativeArraySizeException if <code>repeat < 0</code>
     * @throws NullPointerException if str is <code>null</code>
     */
    private static String repeat( String str, int repeat )
    {
        StringBuffer buffer = new StringBuffer( repeat * str.length() );

        for ( int i = 0; i < repeat; i++ )
        {
            buffer.append( str );
        }

        return buffer.toString();
    }

    /** 
     * Append a description to the buffer by respecting the indentSize and lineLength parameters.
     * <b>Note</b>: The last character is always a new line.
     * 
     * @param sb The buffer to append the description, not <code>null</code>.
     * @param description The description, not <code>null</code>.
     * @param indent The base indentation level of each line, must not be negative.
     */
    private void append( StringBuffer sb, String description, int indent )
    {
        for ( Iterator it = toLines( description, indent, indentSize, lineLength ).iterator(); it.hasNext(); )
        {
            sb.append( it.next().toString() ).append( '\n' );
        }
    }

    /** 
     * Splits the specified text into lines of convenient display length.
     * 
     * @param text The text to split into lines, must not be <code>null</code>.
     * @param indent The base indentation level of each line, must not be negative.
     * @param indentSize The size of each indentation, must not be negative.
     * @param lineLength The length of the line, must not be negative.
     * @return The sequence of display lines, never <code>null</code>.
     * @throws NegativeArraySizeException if <code>indent < 0</code>
     */
    private static List toLines( String text, int indent, int indentSize, int lineLength )
    {
        List lines = new ArrayList();

        String ind = repeat( "\t", indent );
        String[] plainLines = text.split( "(\r\n)|(\r)|(\n)" );
        for ( int i = 0; i < plainLines.length; i++ )
        {
            toLines( lines, ind + plainLines[i], indentSize, lineLength );
        }

        return lines;
    }

    /** 
     * Adds the specified line to the output sequence, performing line wrapping if necessary.
     * 
     * @param lines The sequence of display lines, must not be <code>null</code>.
     * @param line The line to add, must not be <code>null</code>.
     * @param indentSize The size of each indentation, must not be negative.
     * @param lineLength The length of the line, must not be negative.
     */
    private static void toLines( List lines, String line, int indentSize, int lineLength )
    {
        int lineIndent = getIndentLevel( line );
        StringBuffer buf = new StringBuffer( 256 );
        String[] tokens = line.split( " +" );
        for ( int i = 0; i < tokens.length; i++ )
        {
            String token = tokens[i];
            if ( i > 0 )
            {
                if ( buf.length() + token.length() >= lineLength )
                {
                    lines.add( buf.toString() );
                    buf.setLength( 0 );
                    buf.append( repeat( " ", lineIndent * indentSize ) );
                }
                else
                {
                    buf.append( ' ' );
                }
            }
            for ( int j = 0; j < token.length(); j++ )
            {
                char c = token.charAt( j );
                if ( c == '\t' )
                {
                    buf.append( repeat( " ", indentSize - buf.length() % indentSize ) );
                }
                else if ( c == '\u00A0' )
                {
                    buf.append( ' ' );
                }
                else
                {
                    buf.append( c );
                }
            }
        }
        lines.add( buf.toString() );
    }

    /** 
     * Gets the indentation level of the specified line.
     * 
     * @param line The line whose indentation level should be retrieved, must not be <code>null</code>.
     * @return The indentation level of the line.
     */
    private static int getIndentLevel( String line )
    {
        int level = 0;
        for ( int i = 0; i < line.length() && line.charAt( i ) == '\t'; i++ )
        {
            level++;
        }
        for ( int i = level + 1; i <= level + 4 && i < line.length(); i++ )
        {
            if ( line.charAt( i ) == '\t' )
            {
                level++;
                break;
            }
        }
        return level;
    }
}
