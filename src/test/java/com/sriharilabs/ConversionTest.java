/**
 * Copyright 2012-2017 Gunnar Morling (http://www.gunnarmorling.de/)
 * and/or other contributors as indicated by the @authors tag. See the
 * copyright.txt file in the distribution for a full listing of all
 * contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sriharilabs;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

//import static org.junit.Assert.assertThat;

import org.junit.Test;


public class ConversionTest {

    @Test
    public void shouldApplyConversions() {
        Source source = new Source();
        source.setFoo(42);
        source.setBar(23L);
        source.setZip(73);

        Target target = SourceTargetMapper.INSTANCE.sourceToTarget(source);

        System.out.println(target.getQax());
        assertNotNull(target);
         assertThat(target.getFoo(), is(42L));
         assertThat(target.getBar(), is(23));
         assertThat(target.getBar(), is("73"));
    }

    @Test
    public void shouldHandleNulls() {
        Source source = new Source();
        Target target = SourceTargetMapper.INSTANCE.sourceToTarget(source);
        
        assertNotNull(target);
        assertThat(target.getFoo(), is(0L));
        assertThat(target.getBar(), is(0));
        assertThat(target.getZip(), is("0"));

		
    }

    @Test
    public void shouldApplyConversionsToMappedProperties() {
        Source source = new Source();
        source.setQax(42);
        source.setBaz(23L);

        Target target = SourceTargetMapper.INSTANCE.sourceToTarget(source);
        assertNotNull(target);
        assertThat(target.getBaz(), is(42L));
        assertThat(target.getQax(), is(23));
    }

    @Test
    public void shouldApplyConversionsForReverseMapping() {
        Target target = new Target();
        target.setFoo(42L);
        target.setBar(23);
        target.setZip("73");

        Source source = SourceTargetMapper.INSTANCE.targetToSource(target);
        assertNotNull(target);
        assertThat(target.getFoo(), is(42L));
        assertThat(target.getBar(), is(23));
        assertThat(target.getZip(), is("73"));
		
    }

    @Test
    public void shouldApplyConversionsToMappedPropertiesForReverseMapping() {
        Target target = new Target();
        target.setQax(42);
        target.setBaz(23L);

        Source source = SourceTargetMapper.INSTANCE.targetToSource(target);
        assertThat(target.getQax(), is(42));
        assertThat(target.getBaz(), is(23L));
		/*
		 * assertThat(source).isNotNull(); assertThat(source.getBaz()).isEqualTo(42);
		 * assertThat(source.getQax()).isEqualTo(23);
		 */
    }
}
