package org.openmrs.module.emrapi.utils;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.ConceptSource;
import org.openmrs.module.emrapi.EmrApiProperties;
import org.openmrs.test.BaseModuleContextSensitiveTest;
import org.springframework.beans.factory.annotation.Autowired;

public class ModulePropertiesComponentTest extends BaseModuleContextSensitiveTest {

    @Autowired
    private EmrApiProperties emrApiProperties;

    @Before
    public void setup() throws Exception {
        executeDataSet("modulePropertiesComponentTestDataset.xml");
    }

    @Test
    public void shouldFetchConceptSourceByUuid() {
        // this concept source is in the standard test data set
        ConceptSource source = emrApiProperties.getConceptSourceByGlobalProperty("emr.someConceptSource");
        Assert.assertNotNull(source);
        Assert.assertEquals("Some Standardized Terminology", source.getName());

    }

}