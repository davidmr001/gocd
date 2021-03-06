/*************************GO-LICENSE-START*********************************
 * Copyright 2014 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *************************GO-LICENSE-END***********************************/

package com.thoughtworks.studios.shine.cruise;

import com.thoughtworks.go.domain.StageIdentifier;
import com.thoughtworks.go.server.dao.StageDao;
import com.thoughtworks.studios.shine.cruise.stage.StageLookerUpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DatabaseStageLookerUpper implements StageLookerUpper {
    private StageDao stageDao;
    private String baseURL;
    private StageURIGenerator stageURIGenerator;

    @Autowired
    public DatabaseStageLookerUpper(StageURIGenerator stageURIGenerator, StageDao stageDao) {
        this.stageURIGenerator = stageURIGenerator;
        this.stageDao = stageDao;
    }

    public String lookUpStageURL(StageIdentifier stageIdentifier) {
        long stageId = stageDao.findStageWithIdentifier(stageIdentifier).getId();
        return stageURIGenerator.stageUrl(stageId);

    }
}
