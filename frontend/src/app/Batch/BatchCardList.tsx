import React, {useEffect, useState} from "react";
import axios from "axios";
import {environment} from "@app/environment";
import {Flex, FlexItem} from "@patternfly/react-core";
import {BatchCard} from "@app/Batch/BatchCard";
import {backendApi} from "@app/utils/axios-config";

export const BatchCardList = () => {

  const [batches, setBatches] = useState([])

  useEffect(() => {
    const getBatchsListData = async () => {
      const result = await backendApi.get(`/batch/all`)
      setBatches(result)
      // wineries = result.data
    }
    getBatchsListData()
  }, []);

  // @ts-ignore
  return (
    <Flex style={{ margin: '15px' }}>
      {/*// <Gallery>*/}
      {batches.map(batch => {
        return(
          // @ts-ignore
          <FlexItem key={batch.id}><BatchCard  batch={batch} /></FlexItem>


        )})}
    </Flex>
  )

}
