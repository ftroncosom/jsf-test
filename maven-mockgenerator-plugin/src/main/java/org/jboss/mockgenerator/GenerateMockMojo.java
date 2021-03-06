/*
 * $Id$
 *
 * License Agreement.
 *
 * Rich Faces - Natural Ajax for Java Server Faces (JSF)
 *
 * Copyright (C) 2007 Exadel, Inc.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License version 2.1 as published by the Free Software Foundation.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301  USA
 */

package org.jboss.mockgenerator;

import java.io.File;
import java.util.List;

/**
 * <p class="changed_added_4_0"></p>
 * Goal which generates EasyMock Java classes.
 * 
 * @goal generate-mock
 * @requiresDependencyResolution compile
 * @phase generate-sources
 * @author asmirnov@exadel.com
 *
 */
public class GenerateMockMojo extends AbstractMockMojo {

    /**
     * Location of the plugin configuration file.
     * 
     * @parameter expression="src/main/config/mocks.xml"
     * @required
     */
    private File config;
    /**
     * Directory where the output Java Files will be located.
     * 
     * @parameter 
     *            expression="${project.build.directory}/generated-sources/mocks"
     */
    private File outputJavaDirectory;
    /**
     * Project classpath.
     * 
     * @parameter expression="${project.compileClasspathElements}"
     * @required
     * @readonly
     */
    private List<String> classpathElements;

    @Override
    protected void addGeneratedSourcesToProject() {
        // Tell project about generated files.
        project.addCompileSourceRoot(getOutputJavaDirectory().getAbsolutePath());
    }

    @Override
    protected File getOutputJavaDirectory() {
        return this.outputJavaDirectory;
    }

    @Override
    protected File getConfig() {
        return config;
    }

    @Override
    protected List<String> getClasspathElements() {
        return classpathElements;
    }

}
